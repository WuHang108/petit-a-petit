#include "lesson2_2.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        size_t i = 0;
        vector<int> input;
        readIntVector(input, &i);
        printf("%d\n", solution(input));
    }
    return 0;
}

