#include "../basic_io.hpp"
using namespace std;

inline void swap(int* pn, int* pm) {
    if(*pn == *pm) return;
    *pn = *pn ^ *pm;
    *pm = *pn ^ *pm;
    *pn = *pn ^ *pm;
}

int gcd(int n, int m) {
    while (m > 0) {
        n = n % m;
        swap(n, m);
    }
    return n;
}

int solution(vector<int>& A, vector<int>& B) {
    int cnt = 0;
    int Z = A.size();
    for(int i=0; i<Z; ++i) {
        int g = gcd(A[i], B[i]);
        if(g == 1) {
            if(A[i] == 1 && B[i] == 1) ++cnt;
            continue;
        }
        int leftA = A[i] / g;
        int leftB = B[i] / g;
        int common;
        while(leftA > 1) {
            common = gcd(g, leftA);
            if(common == 1) break;
            leftA /= common;
        }
        while(leftB > 1) {
            common = gcd(g, leftB);
            if(common == 1) break;
            leftB /= common;
        }
        if(leftA == 1 && leftB == 1) {
            cnt ++;
        }
    }
    return cnt;
}