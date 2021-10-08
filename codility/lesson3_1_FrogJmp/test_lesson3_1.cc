#include "lesson3_1.hpp"    // include solution file

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        // code here
        int X, Y, D;
        read_specific('(', &i);
        read_int(&X, &i);
        read_specific(',', &i);
        read_int(&Y, &i);
        read_specific(',', &i);
        read_int(&D, &i);
        printf("jump=%d\n", solution(X, Y, D));
    }
    return 0;
}

