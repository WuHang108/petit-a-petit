/*
 * @lc app=leetcode id=504 lang=java
 *
 * [504] Base 7
 */
// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        boolean isminus = false;
        if (num < 0) {
            isminus = true;
            num = - num;
        } else if(num == 0) {
            return "0";
        }
        char[] res7 = new char[14];
        int i = 0;
        while(num > 0) {
            res7[i] = (char) ('0' + (char) (num % 7));
            num = num / 7;
            ++i;
        }
        int len = i;
        char[] str7 = new char[len];
        for(i=0;i<len;++i) {
            str7[i] = res7[len-1-i];
        }
        String ans = String.valueOf(str7);
        if(isminus) {
            ans = "-" + ans;
        }
        return ans;
    }
}
// @lc code=end