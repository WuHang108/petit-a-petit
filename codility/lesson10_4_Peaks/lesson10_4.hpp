#include "../basic_io.hpp"
using namespace std;


int solution(vector<int>& A) {
    int N = A.size();
    vector<int> peaks;
    for(int P=1; P<N-1; ++P) {
        if(A[P-1] < A[P] && A[P] > A[P+1]) {
            peaks.push_back(P);
        }
    }
    for(int step=1; step<=N; ++step) {
        if(N % step != 0) continue;
        int groups = N/step;    // 在每段长度为step时，应该拆分的组数
        int find = 0;   // 记录当前已匹配到的组数
        bool ok = true;
        for(int peakI : peaks) {
            if(peakI / step > find) { // find组没有极值
                ok = false;
                break;
            } else if(peakI / step == find) {
                ++find;
            }
            // 若 peakI/step < find，则继续遍历下一个peakI
        }
        if(find != groups) ok = false;
        if(ok) {
            return groups;
        }
    }
    return 0;
}
