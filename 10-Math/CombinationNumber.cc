#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int main() {
    int n = 0, m = 0;
    scanf("%d%d", &n, &m);
    ll** dp = new ll*[n+1];
    for(int i=0; i<=n; ++i) {
        dp[i] = new ll[m+1];
        dp[i][0] = 1;
    }
    for(int i=1; i<=m; ++i) {
        for(int j=i; j<=n; ++j) {
            dp[j][i] = (dp[j-1][i-1]%1000000007 + dp[j-1][i]%1000000007) % 1000000007;
        }
    }
    printf("%lld\n", dp[n][m]);
    return 0;
}
