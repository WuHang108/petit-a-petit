/*
 * @lc app=leetcode id=566 lang=java
 *
 * [566] Reshape the Matrix
 */

// @lc code=start
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int K = nums.length;
        int L = nums[0].length;
        if(r*c != K*L){
            return nums;
        }
        int[][] res = new int[r][c];
        int k = 0;
        int l = 0;
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                int index = i*c + j;
                k = index / L;
                l = index % L;
                res[i][j] = nums[k][l];
            }
        }
        return res;
    }
}
// @lc code=end

