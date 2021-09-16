#include "../basic_io.hpp"
using namespace std;

const int MAX_N = 400005;
int P[MAX_N];

int solution(vector<int>& A) {
    int sum = 0;
    int N = A.size();
    if(N <= 1) {
        return 0;
    }
    for(int i=1; i<N; ++i) {
        int diff = A[i]-A[i-1];
        if(diff >= 0) {
            sum += diff;
            P[i] = sum;
        } else {
            if(sum + diff < 0) {
                sum = 0;
                P[i] = sum;
            } else {
                sum += diff;
                P[i] = sum;
            }
        }
    }
    int maxP = 0;
    for(int i=0; i<N; ++i) {
        maxP = max(maxP, P[i]);
    }
    return maxP;
}
