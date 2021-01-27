/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int pivot=0;
        for(int num : nums){
            if(num!=0){
                nums[pivot++] = num;
            }
        }
        while(pivot < nums.length) {
            nums[pivot++] = 0;
        }
    }
}
// @lc code=end

