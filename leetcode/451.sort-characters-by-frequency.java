/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 */
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
// @lc code=start
class Solution {
    public String frequencySort(String s) {
        char[] str = s.toCharArray();
        Map<Character, Integer> freq = new HashMap<>();
        for(int i=0; i<str.length; ++i){
            if(freq.containsKey(str[i])){
                freq.put(str[i], freq.get(str[i]));
            } else {
                freq.put(str[i], 1);
            }
        }
        List<Character>[] bucket = new List[s.length()+1];
        if(freq.isEmpty() == false){
            Set<Character> char_keys = (Set<Character>) freq.keySet();
            for(Character c:char_keys){
                if(bucket[freq.get(c)] == null){
                    bucket[freq.get(c)] = new ArrayList<>();
                    bucket[freq.get(c)].add(c);
                } else {
                    bucket[freq.get(c)].add(c);
                }
            }
        }
        
        StringBuilder res = new StringBuilder();
        int i = bucket.length;
        while(bucket[--i] == null);
        for(;i>=0;--i){
            if(bucket[i] != null) for(char c:bucket[i]){
                res.append(c);
            }
        }
        return res.toString();
    }
}
// @lc code=end

