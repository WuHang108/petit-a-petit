/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 */
import java.util.*;
// @lc code=start
class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        ArrayList<ArrayList<String>> dp = new ArrayList<>(s1.length);
        for(int i=0; i<s1.length; ++i) {
            ArrayList<String> row = new ArrayList<String>(s2.length);
            for(int j=0; j<s2.length; ++j) {
                String cs = null;
                if(i==0 && j==0) {
                    if(s1[i] == s2[j]) {
                        cs = String.valueOf(s1[i]);
                    } else {
                        cs = "";
                    }
                    row.add(j, cs);
                } else if(i==0) {
                    if(s1[i] == s2[j]) {
                        cs = String.valueOf(s1[i]);
                    } else {
                        cs = row.get(j-1);
                    }
                    row.add(j, cs);
                } else if(j==0) {
                    if(s1[i] == s2[j]) {
                        cs = String.valueOf(s1[i]);
                    } else {
                        cs = dp.get(i-1).get(j);
                    }
                    row.add(j, cs);
                } else { // i!=0,j!=0
                    if(s1[i] == s2[j]) {
                        cs = dp.get(i-1).get(j-1) + s1[i];
                    } else if(dp.get(i-1).get(j).length() > row.get(j-1).length()){
                        cs = dp.get(i-1).get(j);
                    } else {
                        cs = row.get(j-1);
                    }
                    row.add(j, cs);
                }
            }
            dp.add(i, row);
        }
        String lcs = dp.get(s1.length-1).get(s2.length-1);
        return lcs.length();
    }
}
// @lc code=end

