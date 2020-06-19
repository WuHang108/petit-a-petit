/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */
import java.util.*;
// @lc code=start
class Solution {
    void backtracking(List<Integer> arr, List<List<Integer>> res, boolean[] visited, final int[] nums){
        if(arr.size() == nums.length){
            res.add(new LinkedList<>(arr));
            return ;
        }
        for(int i=0; i<nums.length; ++i){
            if(visited[i]) continue;
            visited[i] = true;
            arr.add(nums[i]);
            backtracking(arr, res, visited, nums);
            arr.remove(arr.size()-1);
            visited[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> arr = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(arr, res, visited, nums);
        return res;
    }
}
// @lc code=end

