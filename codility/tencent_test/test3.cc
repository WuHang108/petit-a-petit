#include<bits/stdc++.h>
typedef long long ll;

const int MAX_N = 102;
char s[MAX_N];

int level(char signal) {
    if(signal == '@') return 3;
    if(signal == 'x') return 2;
    return 1;
}

int main() {
    scanf("%s", s);
    std::stack<char> sigSt;
    std::vector<std::string> poland;
    for(int i=0,len=strlen(s); i<len; ++i) {
        if(! isdigit(s[i])) {
            while(! sigSt.empty() && level(s[i]) <= level(sigSt.top())) {
                std::string temp = {sigSt.top()};
                poland.push_back(temp);
                sigSt.pop();
            }
            sigSt.push(s[i]);
        } else {
            std::string numStr = {s[i]};
            while(isdigit(s[++i])) {
                numStr.push_back(s[i]);
            }
            --i;
            poland.push_back(numStr);
        }
    }
    while(! sigSt.empty()) {
        poland.push_back({sigSt.top()});
        sigSt.pop();
    }
    // for(std::string& test : poland){std::cout << test;}
    // std::cout << std::endl;
    ll ans = 0;
    std::stack<ll> numSt;
    for(std::string& item : poland) {
        if(isdigit(item[0])) {
            ll num = item[0]-'0';
            for(int i=1; i<item.size(); ++i) {
                num = 10*num + item[i] - '0';
            }
            numSt.push(num);
        } else {
            if (item[0] == '@'){
                ll b = numSt.top(); numSt.pop();
                ll a = numSt.top(); numSt.pop();
                numSt.push(a|(a+b));
            } else if(item[0] == 'x') {
                ll b = numSt.top(); numSt.pop();
                ll a = numSt.top(); numSt.pop();
                numSt.push(a*b);
            } else if(item[0] == '+') {
                ll b = numSt.top(); numSt.pop();
                ll a = numSt.top(); numSt.pop();
                numSt.push(a+b);
            }
        }
    }
    printf("%lld\n", numSt.top());
    return 0;
}