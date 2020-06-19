/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l=1, h=n;
        while(l<h){
            int m = l + (h-l)/2;
            if(isBadVersion(m) == true){
                h = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
}
// @lc code=end

