/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int l=0, h = nums.length-1;
        while (l<h) {
            int m = l + (h-l)/2;
            if (nums[m]<=nums[h]) {
                h = m;
            } else {
                l = m+1;
            }
        }
        return nums[l];
    }
}
// @lc code=end

