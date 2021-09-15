#include "../basic_io.hpp"
using namespace std;

const int MAX_N = 100005;
int A[MAX_N];
int C[MAX_N];
int G[MAX_N];
int T[MAX_N];

vector<int> solution(string &S, vector<int> &P, vector<int> &Q) {
    A[0] = C[0] = G[0] = T[0] = 0;
	for(int i=0,len=S.size(); i<len; ++i) {
        A[i+1] = A[i];
        C[i+1] = C[i];
        G[i+1] = G[i];
        T[i+1] = T[i];
        switch (S[i]) {
        case 'A':
            A[i+1]++;
            break;
        case 'C':
            C[i+1]++;
            break;
        case 'G':
            G[i+1]++;
            break;
        case 'T':
            T[i+1]++;
            break;
        }
    }
    int M = P.size();
    vector<int> query(M);
    for(int i=0; i<M; ++i) {
        if(A[Q[i]+1]-A[P[i]] > 0) {
            query[i] = 1;
        } else if(C[Q[i]+1] - C[P[i]] > 0) {
            query[i] = 2;
        } else if(G[Q[i]+1] - G[P[i]] > 0) {
            query[i] = 3;
        } else {
            query[i] = 4;
        }
    }
	return query;
}
