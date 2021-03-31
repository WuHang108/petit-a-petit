/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int r = 0;
        for(int i=0; i<32; ++i) {
            int bit = n & 1;
            r = (r<<1) + bit;
            n = n>>1;
        }
        return r;
    }
}
// @lc code=end

