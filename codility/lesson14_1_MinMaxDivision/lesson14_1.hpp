#include "../basic_io.hpp"
using namespace std;

bool block_size_is_valid(vector<int>& A, int max_block_cnt, int max_block_size) {
    int block_sum = 0, block_cnt = 0;
    for(int n:A) {
        if(block_sum + n > max_block_size) { // 超出最大大小限制时建立新块
            block_sum = n;
            block_cnt ++;
        } else {
            block_sum += n;
        }
        if(block_cnt >= max_block_cnt) return false;
    }
    return true;
}

int solution(int K, int M, vector<int> &A) {
    int max_value = 0, sum_A = 0;
    for(int n : A) {
        max_value = max(max_value, n);
        sum_A += n;
    }
    if(K == 1) return sum_A;
    if(K >= A.size()) return max_value;

    int low_bound = max_value, high_bound = sum_A;
    while(low_bound <= high_bound) {
        int mid = low_bound + (high_bound - low_bound) / 2;
        if(block_size_is_valid(A, K, mid)) {
            high_bound = mid - 1;
        } else {
            low_bound = mid + 1;
        }
    }
    return low_bound;
}
