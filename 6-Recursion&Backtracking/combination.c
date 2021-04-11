#include <stdio.h>
#include <stdlib.h> // malloc
#include <string.h> // memcpy

#define MAX_N 10001

int ans_size;
int temp_size;
void findComb(int** ans, int n, int k, int* temp, int i);

/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** combine(int n, int k, int* returnSize, int** returnColumnSizes){
    int** ans = malloc(MAX_N * sizeof(int*));
    int* tmp = malloc(k * sizeof(int));
    ans_size = temp_size = 0;
    findComb(ans, n, k, tmp, 0);
    *returnSize = ans_size;
    *returnColumnSizes = malloc(ans_size * sizeof(int));
    for(int i=0; i<ans_size; ++i) {
        (*returnColumnSizes)[i] = k;
    }
    return ans;
}

void findComb(int** ans, int n, int k, int* temp, int i) {
    if (temp_size == k)
    {
        int* comb = malloc(k * sizeof(int));
        // memcpy(comb, temp, k * sizeof(int));
        for (int i = 0; i < k; i++) {
            comb[i] = temp[i];
        }
        ans[ans_size++] = comb;
        return ;
    } else if(i == n) {
        return ;
    }
    // 递归
    temp[temp_size++] = i+1;
    findComb(ans, n, k, temp, i+1); // 取
    // 回溯
    temp_size--;
    findComb(ans, n, k, temp, i+1);
}

int main() {
    int return_size = 0;
    int* return_column_size = NULL;
    int** res = combine(4, 2, &return_size, &return_column_size);
    for(int i=0; i<return_size; ++i) {
        printf("[");
        for(int j=0; j<return_column_size[i]; ++j) {
            printf("%d,", res[i][j]);
        }
        printf("]");
    }
    putchar('\n');
    return 0;
}