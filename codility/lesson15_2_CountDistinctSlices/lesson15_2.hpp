#include "../basic_io.hpp"
using namespace std;

const int MAX_M = 100002;
bool appear[MAX_M];

int solution(int M, vector<int> &A) {
    int N = A.size();
    int ans = 0;
    int l = 0, r = 0;
    while(l<N && r<N) {
        if(appear[A[r]]) { // already appears
            appear[A[l++]] = false;   // left move forward
        } else {
            appear[A[r]] = true;
            ans += (r - l + 1);
            if(ans >= 1e9) {
                return 1e9;
            }
            ++r;    // right move forward
        }
    }
    return ans;
}