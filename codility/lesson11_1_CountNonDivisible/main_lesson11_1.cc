#include "lesson11_1.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        vector<int> A;
        read_vector_int(A, &i);
        vector<int> ans = solution(A);
        for(int n:ans) {
            printf("%d,", n);
        }
        nl;
    }
    return 0;
}

