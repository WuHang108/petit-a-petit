#include "lesson16_2.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        read_specific('(', &i);
        int K;
        read_int(&K, &i);
        read_specific(',', &i);
        vector<int> A;
        read_vector_int(A, &i);
        read_specific(',', &i);
        int ans = solution(K, A);
        printf("maximum ropes=%d\n", ans);
    }
    return 0;
}
