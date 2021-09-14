#include "../basic_io.hpp"
using namespace std;

int solution(int X, vector<int>& A) {
	set<int> pos;
	for(int i=0,len=A.size(); i<len; ++i) {
		pos.insert(A[i]);
		if (pos.size() == X) {
			return i;
		}
	}
	return -1;
}
