import java.util.Arrays;

/*
 * @lc app=leetcode id=645 lang=java
 *
 * [645] Set Mismatch
 */

// @lc code=start
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] buckets = new int[nums.length];
        for(int i=0; i<nums.length; ++i){
            if (buckets[nums[i]-1] > 0){
                res[0] = nums[i]; //duplicated
            } else 
                buckets[nums[i]-1] = nums[i];
        }
        for (int i=0; i<buckets.length; ++i){
            if(buckets[i]==0){
                res[1] = i+1; //missed
                break;
            }
        }
        return res;
    }
}
// @lc code=end

