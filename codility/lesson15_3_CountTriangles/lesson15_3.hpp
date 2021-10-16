#include "../basic_io.hpp"
using namespace std;


int solution(vector<int> &A) {
    int N = A.size();
    if(N < 3) return 0;
    sort(A.begin(), A.end());
    int l = 0, m = 1, r = 2;
    int ans = 0;
    // l,m,r不同即可，允许A[l],A[m],A[r]重复
    for(l = 0; l < N-2; ++l) {
        r = l + 2;
        for(m = l+1; m < N-1; ++m) {
            while(r < N && A[l]+A[m]>A[r]) {
                // printf("%d,%d,%d\n", A[l],A[m],A[r]);
                ++r;
            }
            // printf("%d+=%d:", ans, r-m-1);
            ans += (r-m-1);
            // printf("ans=%d\n", ans);
        }
    }
    return ans;
}