/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sub = s.toCharArray();
        char[] tar = t.toCharArray();
        int i1=0,i2=0;
        while(i1<sub.length && i2<tar.length){
            if(sub[i1] == tar[i2]){
                ++i1;++i2;
            } else {
                ++i2;
            }
        }
        if(i1<sub.length) return false;
        return true;
    }
}
// @lc code=end

