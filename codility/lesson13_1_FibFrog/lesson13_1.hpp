#include "../basic_io.hpp"
using namespace std;


const int MAX_N = 100005;
int dp[MAX_N]; // dp[i] 表示到达 i 位置需要的最小跳数, -1为不可达

vector<int> get_fib_seq_up_to_n(int N) {
    // 经预估，前26个Fibonacci数小于MAX_N
    vector<int> fib(27);
    fib[0] = 0, fib[1] = 1;
    for(int i=2; i<27; ++i) {
        fib[i] = fib[i-1] + fib[i-2];
        if(fib[i] > N) {
            return vector<int>(fib.begin()+2, fib.begin()+i);
        }
    }
    return vector<int>(fib.begin()+2, fib.end());
}

int solution(vector<int>& A) {
    int N = A.size();
    if(N == 0) return 1;
    // 将 A[n]=1 加入，可以简化代码
    A.push_back(1);
    // 筛出Fibonacci数
    vector<int> fib_set = get_fib_seq_up_to_n(N+1);
    // 一跳就能跳到的数
    memset(dp, 0xff, sizeof(dp));
    for(int jump : fib_set) {
        if(A[jump - 1] == 1)
            dp[jump - 1] = 1;
    }

    for(int idx=0; idx<=N; idx++) {
        // 忽略非树叶和已经在第一次遍历中标记为可达的位置
        if(A[idx] == 0 || dp[idx] > 0) continue;
        // 获取到达 i 位置需要的最小跳数
        int min_value = MAX_N; // 记录最小跳数
        int min_idx = -1;   // 记录达到最小跳数的前一跳index
        for(int jump : fib_set) {
            int previous_idx = idx - jump; // 找一跳跳到idx位置的前一位置
            if(previous_idx < 0) break;
            if(dp[previous_idx]>0 && min_value>dp[previous_idx]) {
                min_value = dp[previous_idx];
                min_idx = previous_idx;
            }
        }
        if(min_idx != -1) { // 存在前一跳
            dp[idx] = min_value + 1;
        }
    }
    return dp[N];
}