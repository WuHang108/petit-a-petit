#include "../basic_io.hpp"
using namespace std;


int solution(string& S) {
    int N = S.size();
    if(N == 0) {
        return 1;
    }
    if(N == 1) {
        return 0;
    }
    stack<char> st;
    for(char c:S) {
        switch (c)
        {
        case '(':
        case '{':
        case '[':
            st.push(c);
            break;
        case ']':
            if(st.empty() || st.top() != '[') {
                return 0;
            }
            st.pop();
            break;
        case '}':
            if(st.empty() || st.top() != '{') {
                return 0;
            }
            st.pop();
            break;
        case ')':
            if(st.empty() || st.top() != '(') {
                return 0;
            }
            st.pop();
            break;
        default:
            break;
        }
    }
    return st.empty();
}
