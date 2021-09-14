#include "../basic_io.hpp"
using namespace std;

void swap(vector<int>& A, int i, int j) {
	if(i == j) return;
	A[i] = A[i] ^ A[j];
	A[j] = A[i] ^ A[j];
	A[i] = A[i] ^ A[j];
}

int solution(vector<int>& A) {
	int N=A.size(), l=0, r=N-1;
	while(l <= r) {
		if(A[l] == l+1) {
			++l;
		} else if(A[l]<=l || A[l]>r+1 || A[A[l]-1]==A[l]) {
			A[l] = A[r--];
		} else {
			swap(A, l, A[l]-1);
		}
	}
	return l+1;
}
