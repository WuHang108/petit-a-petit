#include "../basic_io.hpp"
using namespace std;


const int MAX_N = 100005;
bool F[MAX_N];
int Next[MAX_N];
int dp[MAX_N]; // dp[i] 表示到达 i 位置需要的最小跳数, -1为不可达

int solution(vector<int>& A) {
    // 筛出Fibonacci数
    int M_1 = 0, M_2 = 1;
    F[M_1] = true;
    F[M_2] = true;
    int M = M_1 + M_2;
    while(M < MAX_N) {
        F[M] = true;
        M_2 = M_1;
        M_1 = M;
        M = M_1 + M_2;
    }

    // 构建next数组
    int N = A.size();
    if(N == 0) return 1;
    int nextPos = N;
    for(int i=N-1; i>=0; --i) {
        Next[i] = nextPos;
        if(A[i] == 1) {
            nextPos = i;
        }
    }

    memset(dp, 0x7, sizeof(dp));
    dp[0] = 1;
    A.push_back(1);
    for(int i=1; i<=N; i++) {
        if(F[i+1]) {
            dp[i] = 1;
        } else if(A[i]>0) {
            for(int j=0; j<i; j=Next[j]) {
                if(A[j]>0 && F[i-j]) {
                    dp[i] = std::min(dp[i], dp[j]+1);
                }
            }
        }
    }
    if(dp[N] >= MAX_N) return -1;
    return dp[N];
}