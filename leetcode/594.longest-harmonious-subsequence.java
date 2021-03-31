import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=594 lang=java
 *
 * [594] Longest Harmonious Subsequence
 */

// @lc code=start
class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; ++i) {
            if (map.get(nums[i]) == null) {
                LinkedList<Integer> newList = new LinkedList<>();
                newList.add(nums[i]);
                map.put(nums[i], newList);
            } else {
                LinkedList<Integer> theList = map.get(nums[i]);
                theList.add(nums[i]);
                map.put(nums[i], theList); 
            }
            if (map.get(nums[i]-1) == null) {
                LinkedList<Integer> newList = new LinkedList<>();
                newList.add(nums[i]);
                map.put(nums[i]-1, newList);
            } else {
                LinkedList<Integer> theList = map.get(nums[i]-1);
                theList.add(nums[i]);
                map.put(nums[i]-1, theList);
            }
        }
        int max_res = 0;
        for(Integer key : map.keySet()) {
            LinkedList<Integer> list = map.get(key);
            int min = list.get(0);
            int max = list.get(0);
            for (Integer elem : list) {
                if (max < elem) {
                    max = elem;
                }
                if (min > elem) {
                    min = elem;
                }
            }
            if (max - min == 1) {
                if (max_res < list.size()) {
                    max_res = list.size();
                }
            }
        }
        return max_res;
    }
}
// @lc code=end

