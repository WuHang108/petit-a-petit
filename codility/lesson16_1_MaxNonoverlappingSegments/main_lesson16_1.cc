#include "lesson16_1.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        read_specific('(', &i);
        vector<int> A;
        read_vector_int(A, &i);
        read_specific(',', &i);
        vector<int> B;
        read_vector_int(B, &i);
        read_specific(',', &i);
        int ans = solution(A, B);
        printf("maximum non overlapping=%d\n", ans);
    }
    return 0;
}
