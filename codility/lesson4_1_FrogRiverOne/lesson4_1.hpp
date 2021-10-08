#include "../basic_io.hpp"
using namespace std;

const int MAX_N = 100005;
bool visited[MAX_N];
int bitree[MAX_N];

inline int lowbit(int x) {
	return x & (-x);
}

void insert(int n, int len) {
	if(!visited[n]) {
		visited[n] = true;
		for(int i=n; i<=len; i+=lowbit(i)) {
			bitree[i]++;
		}
	}
}

int get_cnt(int X) {
	int cnt = 0;
	for(int i=X; i>0; i-=lowbit(i)) {
		cnt += bitree[i];
	}
	return cnt;
}

int solution(int X, vector<int>& A) {
	memset(visited, 0, sizeof(visited));
	memset(bitree, 0, sizeof(bitree));
	for(int i=0,len=A.size(); i<len; ++i) {
		insert(A[i], X);
		if (get_cnt(X) == X) {
			return i;
		}
	}
	return -1;
}
