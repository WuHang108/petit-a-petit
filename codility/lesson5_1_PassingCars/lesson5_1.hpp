#include "../basic_io.hpp"
using namespace std;

const int MAX_N = 100005;
int pre_sum[MAX_N];

int solution(vector<int>& A) {
	int N = A.size();
	int base = 0;
	pre_sum[0] = 0;
	for(int i=0; i<N; ++i) {
		if(A[i]) {
			pre_sum[i+1] = pre_sum[i] + base;
		} else {
			base ++;
			pre_sum[i+1] = pre_sum[i];
		}
		if(pre_sum[i+1] > 1000000000) {
			return -1;
		}
	}
	return pre_sum[N];
}
