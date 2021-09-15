#include "../basic_io.hpp"
using namespace std;


int solution(vector<int>& A, vector<int>& B) {
    stack<int> upstream;
    stack<int> downstream;
    int N = A.size();
    for(int i=0; i<N; ++i) {
        if(B[i]) {
            downstream.push(A[i]);
        } else {
            while(! downstream.empty()) {
                if(A[i] > downstream.top()) {
                    downstream.pop();
                    continue;
                } else {
                    break;
                }
            }
            if(downstream.empty()) {
                upstream.push(A[i]);
            }
        }
    }
    return upstream.size() + downstream.size();
}
