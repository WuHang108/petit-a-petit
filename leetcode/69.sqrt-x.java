/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        int l=1, h=x;
        while(l<h){
            int m = l+(h-l)/2;
            if (m > x/m){
                h = m;
            } else if(m == l){
                break;
            } else {
                l = m;
            }
        }
        return l;
    }
}
// @lc code=end

