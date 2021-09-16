#include "../basic_io.hpp"
using namespace std;

const int MAX_N = 400005;
int peak[MAX_N];
int nextP[MAX_N];

int solution(vector<int>& A) {
    int N = A.size();
    int numP = 0;
    memset(peak, 0, sizeof(peak));
    for(int P=1; P<N-1; ++P) {
        if(A[P-1] < A[P] && A[P] > A[P+1]) {
            peak[P] = 1;
        }
    }
    memset(nextP, 0, sizeof(nextP));
    nextP[N-1] = -1;
    for(int i=N-2; i>=0; --i) {
        if(peak[i] == 1) {
            nextP[i] = i;
        } else {
            nextP[i] = nextP[i+1];
        }
    }
    int step = 1;   // iteration step
    numP = 0;
    while((step-1)*step <= N) {
        int pos = 0;
        int num = 0;    // number of peaks in a loop
        while(pos < N && num < step) { // 目前peak数量不能超过步长
            pos = nextP[pos];
            if(pos == -1)
                break;
            num++;
            pos += step;
        }
        numP = max(numP, num);
        step++;
    }
    return numP;
}
