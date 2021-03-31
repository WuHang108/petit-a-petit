import java.io.IOException;
import java.util.HashMap;

/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int num : nums) {
            if(map.get(num) == null) {
                map.put(num, true);
            } else if(map.get(num) == true) {
                map.put(num, false);
            } else {
                return -1;
            }
        }
        for(int key : map.keySet()) {
            if(map.get(key) == true) {
                return key;
            }
        }
        return -1;
    }
}
// @lc code=end

