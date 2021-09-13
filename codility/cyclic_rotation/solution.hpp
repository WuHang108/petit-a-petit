#include "../basic_io.hpp"
using namespace std;

vector<int> solution(vector<int> &A, int K) {
    int len = A.size();
    if(len == 0)
	return A;
    K = K % len;
    if(K == 0) return A;
    vector<int> res;
    for(int i=len-K; i<len-K+len; ++i) {
	res.push_back(A[i%len]);
    }
    return res;
}
