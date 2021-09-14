#include "../basic_io.hpp"
using namespace std;

int solution(vector<int>& A) {
	int len = A.size();
	int left_sum = A[0], right_sum = 0;
	for(int i=1; i<len; ++i) {
		right_sum += A[i];
	}
	int diff = abs(left_sum - right_sum);
	int minDiff = diff;
	for(int p=1; p<len-1; ++p) {
		left_sum += A[p];
		right_sum -= A[p];
		diff = abs(left_sum - right_sum);
		minDiff = min(minDiff, diff);
	}
	return minDiff;
}
