#include "lesson5_4.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        vector<int> A;
        readIntVector(A, &i);
        int ans = solution(A);
        printf("min index=%d\n", ans);
    }
    return 0;
}

