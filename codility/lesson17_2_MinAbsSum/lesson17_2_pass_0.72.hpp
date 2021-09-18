#include "../basic_io.hpp"
using namespace std;

bool dp[1000001]; // dp[i][j] 前i个元素和是否恰好能为j，去除i

int solution(vector<int> &A) {
    int N = A.size();
    if(N == 0) return 0;
    int sum = 0;
    for(int i=0; i<N; ++i) {
        A[i] = A[i]<0?-A[i]:A[i];
        sum += A[i];
    }
    int target = sum/2;
    #ifndef ONLINE_JUDGE
    memset(dp, 0, sizeof(dp));
    #endif
    dp[A[0]] = dp[0] = true;
    for(int i = 1; i < N; ++i) {
        for(int j = target; j >= A[i]; --j) {
            // 不取dp[i-1][j] 取dp[i-1][j-A[i]]
            dp[j] = dp[j] | dp[j-A[i]];
        }
    }
    while(!dp[target]) {
        target--;
    }
    return std::abs(target - (sum-target));
}