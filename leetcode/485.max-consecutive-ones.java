/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res=0, ones=0;
        for(int i=0; i<nums.length; ++i){
            if(nums[i]==1){
                ones++;
            } else if (nums[i]==0 && ones>0){
                res = Math.max(res, ones);
                ones = 0;
            }
        }
        res = Math.max(res, ones);
        return res;
    }
}
// @lc code=end

