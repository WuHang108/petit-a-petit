/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if(x == 0) return true;
        if(x < 0 || x%10 == 0) return false;
        int right = 0;
        while (right < x) {
            right = 10*right + x%10;
            x = x/10;
        }
        return x==right || x==right/10;
    }
}
// @lc code=end

