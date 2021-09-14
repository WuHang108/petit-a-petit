#include "lesson4_2_compare_and_swap.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        
        vector<int> input;
        readIntVector(input, &i);
        int ans = solution(input);
        printf("is permutation? %s\n", ans==1?"true":"false");
    }
    return 0;
}

