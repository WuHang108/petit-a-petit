/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */

// @lc code=start
class Solution {
    boolean isVowel(char c){
        c = Character.toLowerCase(c);
        if(c == 'a'||c=='e'||c=='i'||c=='o'||c=='u') return true;
        return false;
    }
    public String reverseVowels(String s) {
        int index1 = 0, index2 = s.length()-1;
        StringBuilder str = new StringBuilder(s);
        while(index1 <= index2){
            if(isVowel(str.charAt(index1)) && isVowel(str.charAt(index2))){
                char temp = str.charAt(index1);
                str.setCharAt(index1, str.charAt(index2));
                str.setCharAt(index2, temp);
                ++index1;
                --index2;
            } else {
                if(isVowel(str.charAt(index1))==false){
                    ++index1;
                }
                if(isVowel(str.charAt(index2))==false){
                    --index2;
                }
            }
            
        }
        return str.toString();
    }
}
// @lc code=end

