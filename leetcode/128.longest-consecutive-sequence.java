import java.util.Arrays;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 1;
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        for(int i=1; i<nums.length; ++i) {
            int consecutive = 1;
            while(i<nums.length && nums[i]-nums[i-1] <= 1) {
                if (nums[i] - nums[i-1] == 1)
                    consecutive++;
                i++;
            }
            if (longest < consecutive) {
                longest = consecutive;
            }
        }
        return longest;
    }
}
// @lc code=end

