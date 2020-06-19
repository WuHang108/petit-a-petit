/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        for(int pivot=0; pivot<nums.length; ++pivot){
            if(nums[pivot]==0){
                for(int i=pivot+1;i<nums.length;++i){
                    if(nums[i]!=0){
                        int temp = nums[pivot];
                        nums[pivot] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            }
        }
    }
}
// @lc code=end

