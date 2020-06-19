/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */
import java.util.LinkedList;
import java.util.List;
// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        char[] str = S.toCharArray();
        List<Integer> res = new LinkedList<>();
        int i = 0;  // travels from left to right
        int j = str.length-1; // travels from right to left
        int pre=i; // partion left side
        int post=i; // partion right side
        while(i<str.length){
            while(i<j){
                if(str[i] == str[j]){
                    post = Math.max(j, post);
                    break;
                } else {
                    --j;
                }
            }
            if(i==post){
                res.add(post-pre+1);
                pre = post+1;
                post = pre;
            }
            ++i;
            j = str.length-1;
        }
        return res;
    }
}
// @lc code=end

