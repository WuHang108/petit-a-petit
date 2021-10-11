#include "lesson13_2.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        read_specific('(', &i);
        vector<int> A, B;
        read_vector_int(A, &i);
        read_specific(',', &i);
        read_vector_int(B, &i);
        vector<int> ans = solution(A, B);
        printVector(ans);
    }
    return 0;
}
