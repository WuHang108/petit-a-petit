#include "../basic_io.hpp"
using namespace std;


int solution(vector<int> &A) {
    vector<int> positive, negative;
    for(int n:A) {
        if(n > 0) positive.emplace_back(n);
        else if(n < 0) negative.emplace_back(n);
        else return 0;
    }
    sort(positive.begin(), positive.end());
    sort(negative.rbegin(), negative.rend());
    int l1 = positive.size(), l2 = negative.size();
    if(l1 == 0) {
        return 2*abs(negative[0]);
    } else if(l2 == 0) {
        return 2*abs(positive[0]);
    }
    int ans = min(2*abs(negative[0]), 2*abs(positive[0]));
    for(int i1=0, i2=0; i1<l1 && i2<l2; ) {
        int cand = positive[i1] + negative[i2];
        if(cand == 0) return 0;
        ans = min(ans, abs(cand));
        if(cand > 0) { // positive[i1] > |negative[i2]|
            ++i2;
        } else ++i1;
    }
    return ans;
}