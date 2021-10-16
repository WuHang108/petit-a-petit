#include<bits/stdc++.h>

const int MAX_T =  1002;
int arr[MAX_T];
const int MAX_N = 1e6;
bool isPrime[MAX_N+1];
typedef long long ll;

int main() {
    int T;
    scanf("%d", &T);
    memset(isPrime, 1, sizeof(isPrime));
    isPrime[1] = false;
    for(int base=2; base<=sqrt(MAX_N); ++base) if(isPrime[base]) {
        for(int j=base*base; j<MAX_N; j+=base) {
            isPrime[j] = false;
        }
    }
    for(int i=0; i<T; ++i) {
        scanf("%d", arr+i);
        ll fac[4] = {1};
        for(int j=1; j<=2; ++j) {
            ll k = fac[j-1] + arr[i];
            while(! isPrime[k]) {
                ++k;
            }
            fac[j] = k;
        }
        fac[3] = fac[1] * fac[2];
        printf("%lld\n", fac[3]);
    }
    return 0;
}