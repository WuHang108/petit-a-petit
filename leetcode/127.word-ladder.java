/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */
import java.util.*;
// @lc code=start
class Solution {
    int hamming(final String s1, final String s2){
        int dist = 0;
        int strlen = s1.length();
        for(int i=0; i<strlen; ++i){
            if(s1.charAt(i) != s2.charAt(i)) dist++;
        }
        return dist;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = 0;
        Queue<String> searching = new LinkedList<>();
        searching.add(beginWord);
        while(searching.isEmpty() == false){
            int n=searching.size();
            ++len;
            while(n-- > 0){
                String item = searching.remove();
                if(item.equals(endWord)){
                    return len;
                } else {
                    Iterator<String> iter = wordList.iterator();
                    while(iter.hasNext()){
                        String nextstep = iter.next();
                        if(hamming(item, nextstep)==1){
                            iter.remove();
                            searching.add(nextstep);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
// @lc code=end

