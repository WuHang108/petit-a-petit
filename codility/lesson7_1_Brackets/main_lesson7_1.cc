#include "lesson7_1.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        std::string S(read_buffer);
        int ans = solution(S);
        printf("%s\n", ans==1?"nested":"no");
    }
    return 0;
}

