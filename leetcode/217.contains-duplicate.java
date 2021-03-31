import java.util.Arrays;

/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i=1; i<nums.length; ++i) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
