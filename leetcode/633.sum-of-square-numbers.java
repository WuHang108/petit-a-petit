/*
 * @lc app=leetcode id=633 lang=java
 *
 * [633] Sum of Square Numbers
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        int index1 = 0, index2 = (int)Math.sqrt(c);
        while(index1 <= index2){
            if(index1*index1 + index2*index2 < c){
                ++index1;
            } else if(index1*index1 + index2*index2 > c){
                --index2;
            } else return true;
        }
        return false;
    }
}
// @lc code=end

