#include "../basic_io.hpp"
using namespace std;

int solution(vector<int> &A) {
    set<int> S;
    for(int n : A) {
        S.insert(n);
    }
    return S.size();
}
