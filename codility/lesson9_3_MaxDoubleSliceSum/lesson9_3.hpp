#include "../basic_io.hpp"
using namespace std;

int solution(vector<int>& A) {
    int N = A.size();
    if(N <= 3) {
        return 0;
    }
    int max_end_here[N] = {0};
    int leftSum = 0;
    for(int Y=1; Y<N-1; ++Y) {
        leftSum = max(leftSum+A[Y], 0);
        max_end_here[Y+1] = leftSum;
    }

    int max_start_here[N] = {0};
    int rightSum = 0;
    for(int Z=N-2; Z>1; --Z) {
        rightSum = max(rightSum+A[Z], 0);
        max_start_here[Z-1] = rightSum;
    }
    int maxDoubleSum = 0;
    for(int Y = 1; Y < N-1; ++Y) {
        maxDoubleSum = max(maxDoubleSum, max_end_here[Y]+max_start_here[Y]);
    }
    return maxDoubleSum;
}
