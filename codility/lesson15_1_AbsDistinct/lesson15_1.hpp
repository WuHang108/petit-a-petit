#include "../basic_io.hpp"
using namespace std;

const int MAX_N = 100002;
int solution(vector<int> &A) {
    int len=A.size();
    set<int> S;
    for(int i=0; i<len; ++i) {
        S.insert(abs(A[i]));
    }
    return S.size();
}