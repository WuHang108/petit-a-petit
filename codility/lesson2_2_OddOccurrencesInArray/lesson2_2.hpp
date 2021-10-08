#include "../basic_io.hpp"
using namespace std;

int solution(vector<int>& A) {
	int len = A.size();
	if(len == 0) {
		return 0;
	}
	int ans = A[0];
	for(int i=1; i<len; ++i) {
		ans ^= A[i];
	}
  return ans;
}
