import java.util.Arrays;
/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        int j = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i=0; i<g.length; ++i){
            while(j<s.length && g[i] > s[j]){++j;}
            if(j>=s.length) break;
            if(g[i] <= s[j]){
                ++res;
                ++j;
            }
        }
        return res;
    }
}
// @lc code=end

