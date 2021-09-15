#include "lesson5_3.hpp"

int main() {
    while(fgets(read_buffer, BUFFER_SIZE, stdin) != NULL) {
        pre_treat();
        size_t i = 0;
        /* code starts from here */
        read_specific('(', &i);
        string S;
        read_string(S, &i);
        read_specific(',', &i);
        vector<int> P;
        readIntVector(P, &i);
        read_specific(',', &i);
        vector<int> Q;
        readIntVector(Q, &i);
        vector<int> ans = solution(S, P, Q);
        for(int n : ans) {
            printf("%d,", n);
        }
        putchar('\n');
    }
    return 0;
}

