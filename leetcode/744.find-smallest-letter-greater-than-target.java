/*
 * @lc app=leetcode id=744 lang=java
 *
 * [744] Find Smallest Letter Greater Than Target
 */

// @lc code=start
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length-1;
        while(l<h){
            if(target < letters[l]){
                return letters[l];
            } else if(target >= letters[h]){
                target -= 26;
                continue;
            }
            int m = l+(h-l)/2;
            if(target >= letters[m]){
                l = m+1;
            } else {
                h = m;
            }
        }
        return letters[l];
    }
}
// @lc code=end

