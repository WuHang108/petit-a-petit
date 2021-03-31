/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        int pow;
        while(n > 0) {
            if((n&1) != 0) {
                if(n > 1) return false;
            }
            n = n>>1;
        }
        return true;
    }
}
// @lc code=end

