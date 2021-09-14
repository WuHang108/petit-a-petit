#include "lesson3_2.hpp"    // include solution file

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        // code here
        vector<int> input;
        readIntVector(input, &i);
        int ans = solution(input);
        printf("%d\n", ans);
    }
    return 0;
}

