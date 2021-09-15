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
        return -1;
    }
    int cnt = 0;
    for(int i=0; i<N; ++i) {
        if(A[i] == arena.top()) {
            cnt ++;
            if(cnt >= N/2+1) {
                return i;
            }
        }
    }
    return -1;
}
