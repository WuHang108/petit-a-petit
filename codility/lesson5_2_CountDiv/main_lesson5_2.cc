#include "lesson5_2.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        read_specific('(', &i);
        int A, B, K;
        read_int(&A, &i);
        read_int(&B, &i);
        read_int(&K, &i);
        int ans = solution(A, B, K);
        printf("%d\n", ans);
    }
    return 0;
}

