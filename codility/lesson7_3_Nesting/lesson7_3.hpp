#include "../basic_io.hpp"
using namespace std;


int solution(string& S) {
    stack<char> parens;
    int N = S.size();
    if(N == 0) {
        return 1;
    }
    if(N % 2 == 1) {
        return 0;
    }
    for(char c:S) {
        if(c == '(') {
            parens.push(c);
        } else {
            if(parens.empty()) {
                return 0;
            }
            parens.pop();
        }
    }
    return parens.empty();
}
