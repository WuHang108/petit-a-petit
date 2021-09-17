#include "../basic_io.hpp"
using namespace std;

const int MAX_N = 50005;
int cnt[MAX_N*2];   // cnt[n] 记录A中数 n 出现的个数

vector<int> solution(vector<int> &A) {
    int N = A.size();
    memset(cnt, 0, N*sizeof(int));
    for(int n:A) {
        cnt[n]++;
    }
    vector<int> ans(N);
    for(int i=0; i<N; ++i) {
        int divisors = 0;
        for(int j=1; j*j<=A[i]; ++j) {
            if(A[i] % j == 0) {
                divisors += cnt[j];
                if(A[i]/j != j) {
                    divisors += cnt[A[i]/j];
                }
            }
        }
        ans[i] = N - divisors;
    }
    return ans;
}