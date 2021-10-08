// #include "lesson4_1.hpp"
#include "lesson4_1_set.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        read_specific('(', &i);
        int X;
        read_int(&X, &i);
        read_specific(',', &i);
        vector<int> input;
        read_vector_int(input, &i);
        int ans = solution(X, input);
        printf("earliest time = %d\n", ans);
    }
    return 0;
}

