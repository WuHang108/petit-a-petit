/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    int findIndex(int[] nums, int target, boolean left) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = (l + h) / 2;
            if (nums[m] > target || (left && target == nums[m])) {
                h = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = findIndex(nums, target, true);
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = findIndex(nums, target, false)-1;
        return targetRange;
    }
}
// @lc code=end

