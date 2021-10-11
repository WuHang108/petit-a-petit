#include "task3.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        vector<int> A;
        read_vector_int(A, &i);
        int ans = solution(A);
        printf("%d\n", ans);
    }
    return 0;
}
