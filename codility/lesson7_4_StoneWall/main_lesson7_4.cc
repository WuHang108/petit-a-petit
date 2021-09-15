#include "lesson7_4.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        vector<int> H;
        read_vector_int(H, &i);
        int ans = solution(H);
        printf("%d\n", ans);
    }
    return 0;
}

