#include "../basic_io.hpp"
using namespace std;


int solution(int A, int B, int K) {
	int diff;
	if(A == 0) {
		diff = B/K + 1;
	} else {
		diff = B/K - (A-1)/K;
	}
	return diff;
}
