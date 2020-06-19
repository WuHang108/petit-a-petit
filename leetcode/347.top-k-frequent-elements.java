import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length+1];
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        List<Integer> res = new LinkedList<>();
        for(int e:nums){
            if(freq.containsKey(e)){
                int temp = freq.get(e);
                freq.put(e, temp+1);
            } else {
                freq.put(e, 1);
            }
        }
        
        if(freq.isEmpty() == false){
            Set<Integer> set_Key =(Set<Integer>) freq.keySet();
            for(int e:set_Key){
                if(buckets[freq.get(e)]==null){
                    buckets[freq.get(e)] = new ArrayList<>();
                    buckets[freq.get(e)].add(e);
                } else {
                    buckets[freq.get(e)].add(e);
                }
            }
        }
        int i = buckets.length;
        while(buckets[--i]==null);
        for(int j=0;j<k;--i){
            for(int e:buckets[i]){
                res.add(e);
                ++j;
            }
        }
        return res;
    }
}
// @lc code=end

