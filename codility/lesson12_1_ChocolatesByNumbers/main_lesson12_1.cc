#include "lesson12_1.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        int N;
        read_specific('(', &i);
        read_int(&N, &i);
        read_specific(',', &i);
        int M;
        read_int(&M, &i);
        int ans = solution(N, M);
        printf("%d\n", ans);
    }
    return 0;
}
