/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */
import java.util.*;
// @lc code=start
class Solution {
    void backtracking(List<List<Integer>> mat, List<Integer> vec, boolean[] done, int[] nums){
        if(vec.size() >= nums.length){
            mat.add(new ArrayList<>(vec));
            return ;
        }
        for(int i=0; i<nums.length; ++i){
            if(done[i] || (i>0&&nums[i]==nums[i-1]&&done[i-1]==false)) continue;
            vec.add(nums[i]);
            done[i] = true;
            backtracking(mat, vec, done, nums);
            done[i] = false;
            vec.remove(vec.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        boolean[] done = new boolean[nums.length];
        backtracking(res, new ArrayList<>(), done, nums);
        return res;
    }
}
// @lc code=end

