#include "../basic_io.hpp"
using namespace std;

inline void swap(vector<int>& A, int i, int j) {
	if(i == j) return;
	A[i] = A[i] ^ A[j];
	A[j] = A[i] ^ A[j];
	A[i] = A[i] ^ A[j];
}

int solution(vector<int>& A) {
	int len = A.size(), l = 0, r = len-1;
	while(l <= r) {
		if(A[l] == l+1) {
			++l;
		} else if(A[l] <= l || A[l] > r+1 || A[A[l]-1] == A[l]) {
			return 0;
		} else {
			swap(A, l, A[l]-1);
		}
	}
	return 1;
}
