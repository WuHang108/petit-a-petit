/*
 * @lc app=leetcode id=172 lang=java
 *
 * [172] Factorial Trailing Zeroes
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        if(n==0) return ans;
        int base = 5;
        while(n>=base){
            ans += n/base;
            base *= 5;
        }
        return ans;
    }
}
// @lc code=end

