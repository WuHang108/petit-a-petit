/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = numbers.length-1;
        while(numbers[index1]+numbers[index2] != target){
            if(numbers[index1]+numbers[index2] < target){
                ++index1;
            } else if(numbers[index1]+numbers[index2] > target){
                --index2;
            } else break;
        }
        int[] res = {index1+1, index2+1};
        return res;
    }
}
// @lc code=end

