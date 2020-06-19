/*
 * @lc app=leetcode id=766 lang=java
 *
 * [766] Toeplitz Matrix
 */

// @lc code=start
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int X = matrix.length;
        if(X==1) return true;
        int Y = matrix[0].length;
        for(int i=0; i<X-1; ++i){
            for(int j=0; i+j<X-1; ++j){
                if(j+1<Y && matrix[i+j][j] != matrix[i+j+1][j+1]){
                    return false;
                }
            }
        }
        for(int i=1; i<Y-1; ++i){
            for(int j=0; i+j<Y-1; ++j){
                if(j+1<X && matrix[j][i+j] != matrix[j+1][i+j+1]){
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

