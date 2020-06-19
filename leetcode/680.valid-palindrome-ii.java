/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        char[] str = s.toCharArray();
        int i1 = 0, i2 = str.length-1;
        int resume = 0;
        while(i1<i2){
            if(str[i1] != str[i2]){
                if(resume == 0){
                    ++resume;
                    if(str[i1+1]==str[i2] || str[i1]==str[i2-1]){
                        while(i1<i2&&str[i1+1]==str[i2]&&str[i1]==str[i2-1]){
                            ++i1; --i2;
                        }
                        if(i1<i2){
                            if(str[i1+1]==str[i2]) ++i1;
                            else if(str[i1]==str[i2-1]) --i2;
                            else return false;
                        }
                    } else return false;
                } else return false;
            }
            ++i1; --i2;
        }
        return true;
    }
}
// @lc code=end

