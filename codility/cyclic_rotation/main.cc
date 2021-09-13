#include "solution.hpp"


int main() {
    int N;
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL){
	int len = pre_treat();
	vector<int> A;
	size_t i=0;
	if(!read_specific('(', &i)) {
	    break;
	}
	if(!readIntVector(A, &i))
	    break;
	if(!read_specific(',', &i))
	    break;
	int K;
	if(!read_int(&K, &i))
	    break;
	if(!read_specific(')', &i))
	    break;
	vector<int> ans = solution(A, K);
	printVector(ans);
    }
    return 0;
}
