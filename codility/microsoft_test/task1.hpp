#include "../basic_io.hpp"
using namespace std;


int occur[26];   // 0x11 = both upper and lower

string solution(string& S) {
    memset(occur, 0, sizeof(occur));
    for(char c : S) {
        if(isupper(c)) {
            occur[c-'A'] |= 2; 
        } else { // lower
            occur[c-'a'] |= 1;
        }
    }
    for(int i=25; i>=0; --i) {
        if(occur[i] == 3) {
            string ans;
            ans.push_back((const char)('A'+i));
            return ans;
        }
    }
    return "NO";
}