#include "../basic_io.hpp"
using namespace std;


vector<int> solution(int N, vector<int>& A) {
	vector<int> cnt(1+N);
	int upper = 0;
	for(int i=0, len=A.size(); i<len; ++i) {
		if(A[i] <= N) {
			cnt[A[i]]++;
			upper = max(upper, cnt[A[i]]);
		} else {// A[i] == N+1
			for(int i=1; i<=N; ++i) {
				cnt[i] = upper;
			}
		}
	}
	cnt.erase(cnt.begin());
	return cnt;
}
