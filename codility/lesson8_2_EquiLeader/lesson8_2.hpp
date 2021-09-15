#include "../basic_io.hpp"
using namespace std;


int solution(vector<int>& A) {
    int N = A.size();
    stack<int> arena;
    for(int n : A) {
        if(arena.empty() || n == arena.top()) {
            arena.push(n);
        } else {
            arena.pop();
        }
    }
    if(arena.empty()) {
        return 0;
    }
    int cnt = 0;
    for(int i=0; i<N; ++i) {
        if(A[i] == arena.top()) {
            cnt ++;
        }
    }
    int equi = 0;
    if(cnt >= N/2+1) {
        int dominant = arena.top();
        int leftCnt = 0, rightCnt = cnt;
        for(int S=0; S<N-1; ++S) {
            if(A[S] == dominant) {
                leftCnt++;
                rightCnt--;
            }
            if(leftCnt > (S+1)/2 && rightCnt > (N-S-1)/2) {
                ++equi;
            }
        }
    }
    return equi;
}
