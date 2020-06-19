/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */
import java.util.*;
// @lc code=start
class Solution {
    char[][] map;
    Solution(){
        map = new char[128][];
        map['2'] = "abc".toCharArray();
        map['3'] = "def".toCharArray();
        map['4'] = "ghi".toCharArray();
        map['5'] = "jkl".toCharArray();
        map['6'] = "mno".toCharArray();
        map['7'] = "pqrs".toCharArray();
        map['8'] = "tuv".toCharArray();
        map['9'] = "wxyz".toCharArray();
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if(digits.length() <= 1) {
            if(digits.length() == 1){
                for(char d:map[digits.charAt(0)]){
                    res.add(Character.toString(d));
                }
            }
            return res;
        }
        List<String> rset = letterCombinations(digits.substring(1));
        for(String rstr:rset){
            for(char c:map[digits.charAt(0)])
                res.add(Character.toString(c)+rstr);
        }
        return res;
    }
}
// @lc code=end

