#include "lesson4_3.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        read_specific('(', &i);
        int N;
        read_int(&N, &i);
        read_specific(',', &i);
        vector<int> input;
        read_vector_int(input, &i);
        vector<int> ans = solution(N, input);
        for(int v : ans) {
            printf("%d,", v);
        }
        putchar('\n');
    }
    return 0;
}

