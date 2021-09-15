#include "lesson3_3.hpp"    // include solution file

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        vector<int> input;
        read_vector_int(input, &i);
        int ans = solution(input);
        printf("minimal difference = %d\n", ans);
    }
    return 0;
}

