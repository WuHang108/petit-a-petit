#include "../basic_io.hpp"
using namespace std;

const int MAX_N = 100005;

int solution(vector<int> &A) {
    int len = A.size();
    double minV = MAX_N;
    int minI = 0;
    for(int i=0; i<len-2; ++i) {
        if(A[i] + A[i+1] < 2*minV) {
            minV = (A[i] + A[i+1])/2.0;
            minI = i;
        }
        if(A[i] + A[i+1] + A[i+2] < 3*minV) {
            minV = (A[i] + A[i+1] + A[i+2])/3.0;
            minI = i;
        }
    }
    if(A[len-2]+A[len-1] < 2*minV) {
        minV = (A[len-2] + A[len-1])/2.0;
        minI = len - 2;
    }
	return minI;
}
