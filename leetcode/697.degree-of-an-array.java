import java.util.ArrayList;

/*
 * @lc app=leetcode id=697 lang=java
 *
 * [697] Degree of an Array
 */
class LeetCode697 {
    public static void main(String[] args) {
        // Create a new Solution instance
        Solution solution = new Solution();
        // Create a test case
        int testCase[] = {1,2,2,3,1,4,2};
        // Get the answer
        int answer = solution.findShortestSubArray(testCase);
        // Print the answer
        System.out.println(answer);
    }
}
// @lc code=start
class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] bucket = new int[50000];
        int[] start = new int[50000];
        int[] end = new int[50000];
        int degree = 0;
        ArrayList<Integer> index = new ArrayList<>();
        for(int i=0; i<nums.length; ++i){
            if (bucket[nums[i]] == 0){
                start[nums[i]] = i;
            }
            end[nums[i]] = i;
            ++bucket[nums[i]];
            if(bucket[nums[i]] > degree){
                index.clear();
                index.add(nums[i]);
                degree = bucket[nums[i]];
            } else if(bucket[nums[i]] == degree){
                index.add(nums[i]);
            }
        }
        int res = end[index.get(0)] - start[index.get(0)]+1;
        for(int i=1; i<index.size(); ++i){
            if(res>end[index.get(i)]-start[index.get(i)]+1){
                res=end[index.get(i)]-start[index.get(i)]+1;
            }
        }
        return res;
    }
}
// @lc code=end

