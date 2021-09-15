#include "../basic_io.hpp"
using namespace std;

typedef long long ll;
typedef struct triple {
    ll pos;
    bool st;
}triple;

int cmp(const void* v1, const void* v2) {
    const triple* t1 = (const triple*)v1;
    const triple* t2 = (const triple*)v2;
    if(t1->pos == t2->pos) {
        return t2->st - t1->st;
    } else if(t1->pos < t2->pos) {
        return -1;
    }
    return 1;
}

int solution(vector<int> &A) {
    int N = A.size();
    if(N <= 1) {
        return 0;
    }
    triple records[2*N];
    for(ll i=0; i<N; ++i) {
        records[2*i].pos = i - A[i];
        records[2*i].st = true;
        records[2*i+1].pos = i + A[i];
        records[2*i+1].st = false;
    }
    qsort(records, 2*N, sizeof(triple), cmp);
    int pairs = 0;
    int base = 0;
    for(int i=0; i<2*N; ++i) {
        if(records[i].st) {
            pairs += base;
            base++;
        } else {
            base--;
        }
        if(pairs > 10000000) {
            return -1;
        }
    }
	return pairs;
}
