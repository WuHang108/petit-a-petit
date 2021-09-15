#include "../basic_io.hpp"
using namespace std;

const int MAX_N = 100005;

int solution(vector<int> &A) {
    if(A.size() == 3) {
        return A[0]*A[1]*A[2];
    }
    vector<int> plus;
    vector<int> minus;
    bool zero = false;
    for(int n : A) {
        if(n > 0) {
            plus.push_back(n);
        } else if(n < 0) {
            minus.push_back(n);
        } else {
            zero = true;
        }
    }
    sort(plus.begin(), plus.end());
    sort(minus.begin(), minus.end());
    int maxTri = 0;
    int plusLen = plus.size();
    int minusLen = minus.size();
    if(plusLen >= 3) {
        maxTri = plus[plusLen-1]*plus[plusLen-2]*plus[plusLen-3];
        if(minusLen >= 2) {
            maxTri = max(maxTri, minus[0]*minus[1]*plus[plusLen-1]);
        }
    } else if(plusLen == 2) {
        if(zero) {
            maxTri = 0;
        }
        if(minusLen >= 2) {
            maxTri = minus[0]*minus[1]*plus[plusLen-1];
        }
    } else if(plusLen == 1) {
        if(minusLen >= 2) {
            maxTri = minus[0]*minus[1]*plus[0];
        } else {
            maxTri = 0;
        }
    } else { // plusLen = 0
        if(zero) {
            maxTri = 0;
        } else { // minLen >= 4
            maxTri = minus[minusLen-1]*minus[minusLen-2]*minus[minusLen-3];
        }
    }
	return maxTri;
}
