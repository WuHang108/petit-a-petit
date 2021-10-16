#include<bits/stdc++.h>
typedef long long ll;

const int MAX_T =  1002;
const int MAX_N = 2e5+2;
int a[MAX_N];
ll dp[MAX_N];

int main() {
    int T;
    scanf("%d", &T);
    while(T--) {
        int n;
        scanf("%d", &n);
        for(int j=0; j<n; ++j) {
            scanf("%d", a+j);
        }
        memset(dp, 0, sizeof(dp));
        for(int i=0; i<n; ++i) {
            dp[i] = a[i];
        }
        ll ans = a[0];
        for(int i=0; i<n; ++i) {
            if(i + a[i] >= n) {
                ans = std::max(ans, dp[i]);
            } else {
                dp[i+a[i]] = std::max(dp[i+a[i]], dp[i]+a[i+a[i]]);
            }
        }
        printf("%lld\n", ans);
    }
    return 0;
}