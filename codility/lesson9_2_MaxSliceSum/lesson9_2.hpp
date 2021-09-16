#include "../basic_io.hpp"
using namespace std;

const int MAX_N = 400005;
int S[MAX_N];

int solution(vector<int>& A) {
    int N = A.size();
    if(N == 0) {
        return 0;
    }
    int sum = A[0];
    S[0] = A[0];
    for(int i=1; i<N; ++i) {
        sum = S[i-1] + A[i];
        S[i] = max(sum, A[i]);
    }
    int maxS = S[0];
    for(int i=1; i<N; ++i) {
        maxS = max(maxS, S[i]);
    }
    return maxS;
}
