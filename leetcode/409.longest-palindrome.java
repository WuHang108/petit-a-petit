/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        int res = 0;
        int[] bucket = new int[53];
        for(char ch : s.toCharArray()) {
            if(Character.isLowerCase(ch)) {
                bucket[26 + ch - 'a'] ++;
            } else {
                bucket[ch - 'A'] ++;
            }
        }
        int odd = 0;
        for(int i=0; i<bucket.length; ++i) {
            if(bucket[i] % 2 == 0) {
                res += bucket[i];
            } else {
                odd = 1;
                if(bucket[i] > 2) {
                    res += (bucket[i] - 1);
                }
            }
        }
        return res+odd;
    }
}
// @lc code=end

