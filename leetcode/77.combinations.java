/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */
import java.util.*;
// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        bt(res, new ArrayList<>(k), 1, k, n);
        return res;
    }
    void bt(List<List<Integer>> mat, List<Integer> vec, int start, int k, final int N){
        if(k == 0){
            mat.add(new ArrayList<>(vec));
            return ;
        }
        for(int i=start; i<=N-k+1 ; i++){
            vec.add(i);
            bt(mat, vec, i+1, k-1, N);
            vec.remove(vec.size()-1);
        }
    }
}
// @lc code=end

