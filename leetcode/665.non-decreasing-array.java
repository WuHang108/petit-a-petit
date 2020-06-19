/*
 * @lc app=leetcode id=665 lang=java
 *
 * [665] Non-decreasing Array
 */

// @lc code=start
class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums.length<=2) return true;
        int flag=0;
        for(int i=1;i<nums.length;++i){
            if(nums[i]<nums[i-1]){
                if(flag==0){
                    if(i<nums.length-1){
                        if(nums[i-1]<=nums[i+1])
                            nums[i]=nums[i-1];
                        else if(i==1 || nums[i]>=nums[i-2]){
                            nums[i-1]=nums[i];
                        } else
                            return false;
                    }
                    flag=1;
                }
                else return false;
            }
        }
        return true;
    }
}
// @lc code=end

