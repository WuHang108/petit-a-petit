#include "../basic_io.hpp"
using namespace std;


int solution(vector<int>& A, vector<int>& B) {
    int N = A.size();
    if(N == 0) {
        return 0;
    }
    int max_num = 0;
    int st = -1;
    for(int i=0; i<N; ++i) {
        if(A[i] > st) {
            max_num ++;
            st = B[i];
        }
    }
    return max_num;
}
