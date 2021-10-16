#include "lesson15_2.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        read_specific('(', &i);
        int M;
        read_int(&M, &i);
        read_specific(',', &i);
        vector<int> A;
        read_vector_int(A, &i);
        int ans = solution(M, A);
        cout << ans << endl;
    }
    return 0;
}