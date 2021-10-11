#include "../basic_io.hpp"
using namespace std;

typedef long long ll;
const int MAX_N = 50005;
int dp[MAX_N];

vector<int> solution(vector<int> &A, vector<int> &B) {
    dp[0] = dp[1] = 1;
    for(int i=2; i<MAX_N; ++i) {
        dp[i] = ((ll)dp[i-1]%(1<<30) + dp[i-2]%(1<<30)) % (1<<30);
    }
    int L = A.size();
    vector<int> ans;
    for(int i=0; i < L; ++i) {
        ans.emplace_back(dp[A[i]] % (1<<B[i]));
    }
    return ans;
}