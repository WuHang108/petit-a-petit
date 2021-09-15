#include "../basic_io.hpp"
using namespace std;

typedef long long ll;
inline bool judge(int a, int b, int c) {
    return ((ll)a+b>(ll)c && (ll)a+c>(ll)b && (ll)b+c>(ll)a);
}

int solution(vector<int> &A) {
    int N = A.size();
    if(N < 3) {
        return 0;
    }
    sort(A.begin(), A.end());
    for(int i=0; i<N-2; ++i) {
        if(judge(A[i], A[i+1], A[i+2])) {
            return 1;
        }
    }
	return 0;
}
