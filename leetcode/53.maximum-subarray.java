/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = nums[0];
        for(int i=1; i<nums.length; ++i){
            if(nums[i] > 0 && sum < 0){
                sum = nums[i];
            } else if(sum+nums[i]<0){
                sum = Math.max(sum+nums[i],nums[i]);
            } else {
                sum += nums[i];
            }
            if(sum>res) res=sum;
        }
        return res;
    }
}
// @lc code=end

