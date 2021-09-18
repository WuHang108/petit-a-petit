#include "../basic_io.hpp"
using namespace std;

const int MAX_M = 30005;
int sortedNail[MAX_M][2];

int cmp (const void* p1, const void* p2) {
    return ((const int*)p1)[0] - ((const int*)p2)[0];
};

/*
    for each plank, we can use binary search to get the minimal index of
the sorted array of nails, and we should check the candidate nails to get
the minimal index of the original array of nails. */
int getMinIndex(int startPlank, int endPlank, int (*nail)[2], int preIndex, int M) {
    int min = 0;
    int max = M - 1;
    int minIndex = -1;
    while(min <= max) {
        int mid = (min+max)/2;
        if(nail[mid][0] < startPlank) {
            min = mid + 1;
        } else if(nail[mid][0] > endPlank) {
            max = mid - 1;
        } else {
            max = mid - 1;
            minIndex = mid;
        }
    }
    if(minIndex == -1) return -1;
    int minIndexOrigin = nail[minIndex][1];
    // find the smallest original position of nail that can nail the plank
    for(int i=minIndex; i<M; ++i) {
        if(nail[i][0] > endPlank) break;
        minIndexOrigin = std::min(minIndexOrigin, nail[i][1]);
        if(minIndexOrigin <= preIndex)
            return preIndex;
    }
    return minIndexOrigin;
}


int solution(vector<int>& A, vector<int>& B, vector<int> &C) {
    int N = A.size();
    int M = C.size();
    memset(sortedNail, 0, sizeof(sortedNail));
    for(int i=0; i<M; ++i) {
        sortedNail[i][0] = C[i];
        sortedNail[i][1] = i;
    }
    qsort(sortedNail, M, 2*sizeof(int), cmp);
    int result = 0;
    for(int i=0; i<N; ++i) { // find the earliest position that can nail each plank,
        // and the max value for all planks is the result
        result = getMinIndex(A[i], B[i], sortedNail, result, M);
        if(result == -1) {
            return -1;
        }
    }
    return result + 1;
}
