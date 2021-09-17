#include "../basic_io.hpp"
using namespace std;

vector<int> sieve(int N) {
    vector<int> prime = vector<int>(N+1);
    for(int i=2; i<=(double)sqrt(N); i++) {
        if(prime[i] == 0) {
            int k = i*i;
            while(k <= N) {
                if(prime[k] == 0){
                    prime[k] = i; // 记录下其中一个（质）因子
                }                    
                k += i;
            }               
        }
    }
    return prime;
}

vector<int> semiprime(vector<int>& prime) {
    vector<int> semiprime(prime.size());
    for(int i=0;i<prime.size();i++) {
        if(prime[i] == 0) // prime肯定不是semiprime
            continue;
        int firstFactor = prime[i]; // 获取其中一个（质）因子
        if(prime[i/firstFactor] == 0) // second factor也是质数
            semiprime[i]=1;   
    }  
    return semiprime;
}

vector<int> solution(int N, vector<int>& P, vector<int> &Q) {
    int len = P.size();
    vector<int> prime = sieve(N);
    vector<int> semip = semiprime(prime);
    vector<int> res(len);
    vector<int> semiAggre(N+1);
    for(int i=1; i<N+1; ++i) {
        semiAggre[i] = semiAggre[i-1] + semip[i];
    }
    for(int i=0; i<len; ++i) {
        res[i] = semiAggre[Q[i]] - semiAggre[P[i]] + semip[P[i]];
    }
    return res;
}