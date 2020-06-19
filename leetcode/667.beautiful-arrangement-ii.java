/*
 * @lc app=leetcode id=667 lang=java
 *
 * [667] Beautiful Arrangement II
 */

// @lc code=start
class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        res[0] = 1;
        for(int i=1; i<=k; ++i){
            if(i%2==1){
                res[i] = res[i-1] + k+1-i;
            } else {
                res[i] = res[i-1] - (k+1-i);
            }
        }
        for(int i=k+1; i<n; ++i){
            res[i] = i+1;
        }
        return res;
    }
}
// @lc code=end

