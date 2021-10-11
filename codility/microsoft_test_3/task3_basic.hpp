#include "../basic_io.hpp"
using namespace std;

const int MAX_N = 100002;
int order[MAX_N];
vector<int> link;

int cmp(const void* v1, const void* v2) {
    return link[*(const int*)v1] - link[*(const int*)v2];
}

int solution(vector<int> &A) {
    int N = A.size();
    if(N <= 1) return N;
    link = A;
    for(int i=0; i<N; ++i) {
        order[i] = i;
    }
    qsort(order, N, sizeof(int), cmp);
    int l = 0, r = order[0], slice = 0;
    while(l < N) {
        if(l > r) {
            r = order[l]; continue;
        }
        if(l == r) {
            slice ++;
        }
        ++l;
    }
    return slice;
}