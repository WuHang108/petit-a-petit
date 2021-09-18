#include "../basic_io.hpp"
using namespace std;

int dp[2000001]; // dp[j] 前i个元素和恰好能为j时的某数的个数
int cnt[101]; // cnt[i] 统计数i出现的次数

int solution(vector<int> &A) {
    int N = A.size();
    if(N == 0) return 0;
    int sum = 0;
    int max_value = A[0];
    for(int i=0; i<N; ++i) {
        A[i] = A[i]<0?-A[i]:A[i];
        sum += A[i];
        max_value = max_value<A[i]?A[i]:max_value;
    }
    #ifndef ONLINE_JUEGE
    memset(cnt, 0, sizeof(cnt));
    #endif
    for(int i=0; i<N; ++i) {
        cnt[A[i]]++;
    }

    memset(dp, 0xff, sum*sizeof(int));
    dp[0] = 0;
    int target = sum/2;
    for(int a = 1; a <= max_value; ++a) {
        if(cnt[a] > 0) {
            for(int j = 0; j <= target; ++j) {
                if(dp[j] >= 0) {
                    dp[j] = cnt[a];
                } else if(j-a>=0 && dp[j-a] > 0) {
                    dp[j] = dp[j-a] - 1;
                }
            }
        }
    }
    while(dp[target] == -1) {
        target--;
    }
    return std::abs(target - (sum-target));
}