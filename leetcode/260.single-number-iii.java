/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int xor = 0;
        for(int num : nums) xor ^= num;
        int diffbit = xor & (-xor);
        for(int num : nums) {
            if((num&diffbit) == 0) {
                res[0] = res[0] ^ num;
            } else {
                res[1] = res[1] ^ num;
            }
        }
        return res;
    }
}
// @lc code=end

