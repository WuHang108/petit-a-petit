#include "../basic_io.hpp"
using namespace std;


void swap(int* pi, int* pj) {
    if(*pi == *pj) return;
    *pi = *pi ^ *pj;
    *pj = *pi ^ *pj;
    *pi = *pi ^ *pj;
}

int gcd(int N, int M) {
    if(N < M) {
        swap(&N, &M);
    }
    int r = N % M;
    while(r > 0) {
        if(r > M) {
            N = r;
        } else {
            N = M;
            M = r;
        }
        r = N%M;
    }
    return M;
}

int solution(int N, int M) {
    return N/gcd(N,M);
}