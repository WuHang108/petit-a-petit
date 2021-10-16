#include "lesson15_1.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        // read_specific('(', &i);
        vector<int> A;
        read_vector_int(A, &i);
        int ans = solution(A);
        cout << ans << endl;
    }
    return 0;
}