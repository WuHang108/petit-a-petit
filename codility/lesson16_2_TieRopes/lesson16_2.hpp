#include "../basic_io.hpp"
using namespace std;


int solution(int K, vector<int> &A) {
    // sort(A.begin(), A.end(), greater<int>());
    int ans = 0;
    int N = A.size();
    int temp = 0;
    for(int i=0; i<N; ++i) {
        temp += A[i];
        if(temp >= K) {
            ans++;
            temp = 0;
        }
    }
    return ans;
}