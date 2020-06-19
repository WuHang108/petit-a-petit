/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        int res = -1;
        Arrays.sort(nums);
        for(int i=1; i<nums.length; ++i){
            if(nums[i]==nums[i-1]){
                res = nums[i];
                break;
            }
        }
        return res;
    }
}
// @lc code=end

