/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int res = 0 ^ nums.length;
        for(int i = 0; i < nums.length; i++) {
            res = res ^ nums[i] ^ i;
        }
        return res;
    }
}
// @lc code=end

