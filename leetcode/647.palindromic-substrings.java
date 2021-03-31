/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int left_index = 0, right_index = 0;
        char[] str = s.toCharArray();
        if (str.length == 0) return 0;
        for(int i=0; i<str.length; ++i) {
            // odd
            left_index = right_index = i;
            while(left_index>=0 && right_index<str.length && str[left_index] == str[right_index]){
                res++;
                left_index--;
                right_index++;
            }
            // even
            left_index = i;
            right_index = i+1;
            while(left_index>=0 && right_index<str.length && str[left_index]==str[right_index]){
                res++;
                left_index--;
                right_index++;
            }
        }
        return res;
    }
}
// @lc code=end

