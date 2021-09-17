#include "lesson11_2.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        read_specific('(', &i);
        int N;
        read_int(&N, &i);
        read_specific(',', &i);
        vector<int> P;
        read_vector_int(P, &i);
        read_specific(',', &i);
        vector<int> Q;
        read_vector_int(Q, &i);
        vector<int> ans = solution(N, P, Q);
        for(int n:ans) {
            printf("%d,", n);
        }
        nl;
    }
    return 0;
}

