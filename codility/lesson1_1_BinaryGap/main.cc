#include "solution.hpp"

int main() {
    int N;
    while(scanf("%d", &N) != EOF) {
	int ans = solution(N);
	printf("%d\n", ans);
    }
    return 0;
}
