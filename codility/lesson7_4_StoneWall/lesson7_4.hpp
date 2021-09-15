#include "../basic_io.hpp"
using namespace std;


int solution(vector<int>& H) {
    stack<int> stage;
    int block = 0;
    for(int h : H) {
        while(!stage.empty() && h < stage.top()) {
            stage.pop();
        }
        if(!stage.empty() && h == stage.top()) {
            continue;
        } else {
            stage.push(h);
            block++;
        }
    }
    return block;
}
