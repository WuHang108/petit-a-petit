#include "../basic_input.h"

int solution(int N) {
    int ans = 0;
    int state = 0;
    int gap = 0;
    while(N > 0) {
	int bit = N & 1;
	N >>= 1;
	if(bit > 0) {
	    if(state == 0) {
		state = 1;
	    } else if(state==2){
		ans = std::max(ans, gap);
		gap = 0;
		state = 1;
	    }
	} else { // bit = 0
	    if(state == 1) {
		gap++;
		state = 2;
	    } else if(state == 2) {
		gap++;
	    }
	}
    }
    return ans;
}
