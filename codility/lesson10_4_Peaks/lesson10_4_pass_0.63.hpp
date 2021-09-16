#include "../basic_io.hpp"
using namespace std;

const int MAX_N = 400005;
int peak[MAX_N];
int nextP[MAX_N];

int solution(vector<int>& A) {
    int N = A.size();
    memset(peak, 0, sizeof(peak));
    for(int P=1; P<N-1; ++P) {
        if(A[P-1] < A[P] && A[P] > A[P+1]) {
            peak[P] = 1;
        }
    }
    memset(nextP, 0, sizeof(nextP));
    nextP[N-1] = N+1;
    for(int i=N-2; i>=0; --i) {
        if(peak[i] == 1) {
            nextP[i] = i;
        } else {
            nextP[i] = nextP[i+1];
        }
    }
    if(nextP[0] >= N) {
        return 0;
    }
    vector<int> composite_small; // 每个合数组成一段
    vector<int> composite_big;
    for(int i=2; i<=sqrt(N); ++i) {
        if(N % i == 0) {
            if(i != N/i) {
                composite_small.push_back(i);
                composite_big.insert(composite_big.begin(), N/i);
            } else {
                composite_small.push_back(i);
            }
        }
    }
    vector<int> composite(composite_small);
    composite.insert(composite.end(), composite_big.begin(), composite_big.end());
    composite.push_back(N);
    for(int div : composite) {
        if(N % div == 0) {
            int j = nextP[0];
            int k = 0;
            for(; j < N; j = nextP[j], ++k) {
                while(j < k*div) j = nextP[j+1];
                if(j < (k+1)*div) {
                    ++j;
                } else {
                    break;
                }
            }
            if(k*div >= N) {
                return N/div;
            }
        }
    }
    return 0;
}
