import java.util.HashMap;

/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> char2num = new HashMap<>();
        for(char c : s.toCharArray()) {
            char2num.put(c, char2num.getOrDefault(c, 0)+1);
        }
        for(char c : t.toCharArray()) {
            if (char2num.get(c) == null) return false;
            int remain = char2num.get(c) - 1;
            if (remain < 0) return false;
            char2num.put(c, remain);
        }
        for(char c : char2num.keySet()) {
            if(char2num.get(c) != 0) return false;
        }
        return true;
    }
}
// @lc code=end

