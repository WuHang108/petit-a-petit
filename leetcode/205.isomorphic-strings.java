/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] s_lastpos = new int[256];
        int[] t_lastpos = new int[256];
        for(int i=0; i<s.length(); ++i) {
            int pos_s = s_lastpos[s.charAt(i)];
            int pos_t = t_lastpos[t.charAt(i)];
            if(pos_s != pos_t)
                return false;
            s_lastpos[s.charAt(i)] = i+1;
            t_lastpos[t.charAt(i)] = i+1;
        }
        return true;
    }
}
// @lc code=end

