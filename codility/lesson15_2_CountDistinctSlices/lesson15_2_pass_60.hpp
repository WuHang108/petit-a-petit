// https://app.codility.com/demo/results/training7J2NJB-VMN/
#include "../basic_io.hpp"
using namespace std;

const int MAX_M = 100002;
bool appear[MAX_M];

int solution(int M, vector<int> &A) {
    int N = A.size();
    int ans = 0;
    for(int l=0; l<N; ++l) {
        memset(appear, 0, sizeof appear);
        for(int r=l; r<N; ++r) {
            if(appear[A[r]]) { // already appears
                break;
            }
            appear[A[r]] = true;
            ++ans;
        }
        if(ans > 1e9) {
            return 1e9;
        }
    }
    return ans;
}