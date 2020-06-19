/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        final int red=0, white=1, blue=2;
        int i=0, j=nums.length-1;
        while(i<j){
            switch(nums[i]){
                case red:
                ++i;break;
                case blue: 
                int temp=nums[i];nums[i]=nums[j];nums[j]=temp;
                --j; break;
                case white:
                default: break;
            }
            switch(nums[j]){
                case red:
                int temp=nums[j];nums[j]=nums[i];nums[i]=temp; 
                ++i; break;
                case blue:
                --j; break;
                case white:
                default: break;
            }
            if(nums[i]==1&&nums[j]==1){
                int temp;
                int cnt=0;
                for(int k=i; k<=j; ++k){
                    switch(nums[k]){
                        case red:
                        temp=nums[k];nums[k]=nums[i];nums[i]=temp;
                        break;
                        case blue:
                        temp=nums[k]; nums[k]=nums[j]; nums[j]=temp;
                        break;
                        case white:
                        ++cnt;
                        default: break;
                    }
                }
                if(cnt==j-i+1){
                    break;
                }
            }
        }
    }
}
// @lc code=end

