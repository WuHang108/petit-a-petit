/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */
import java.util.*;
// @lc code=start
class Solution {
    List<List<Integer>> combine(int n, int k) {
        boolean[] flags = new boolean[n+1];
        List<List<Integer>> res = new ArrayList<>();
        findCombination(res, flags, k, n, new ArrayList<>(), 1);
        return res;
    }
    
    /*
        res: 所有可能组合
        flags: 标记1...n是否被取
        k: 剩余还需加进comb的数
        n: 数据总数
        comb: 记录当前的组合
        i: 指针在1...n的位置
    */
    void findCombination(List<List<Integer>> res, boolean[] flags, int k, int n, List<Integer> comb, int i) {
        if(k == 0) {
            res.add(new ArrayList<>(comb));
            return ;
        } else if(i > n) {
            return ;
        }
        comb.add(i);
        flags[i] = true;
        findCombination(res, flags, k-1, n, comb, i+1);   // 取
        flags[i] = false;
        comb.remove(comb.size()-1);
        findCombination(res, flags, k, n, comb, i+1);   // 不取
    }

    public List<List<Integer>> combine2(int n, int k) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        for(int i=1; i<=n; ++i) {
            if(i == 1) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                List<List<Integer>> value = new ArrayList<>();
                value.add(list);
                map.put(1, value);
            } else if(i <= k){
                List<List<Integer>> value = new ArrayList<>();
                List<Integer> list = new ArrayList<>(map.get(i-1).get(0));
                list.add(i);
                value.add(list);
                map.put(i, value);
            }
            for(int j=k; j>=1; --j) {
                if(j == 1 && j != i) {
                    List<List<Integer>> value = map.get(j);
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    value.add(list);
                    map.put(j, value);
                } else if(i > j){
                    List<List<Integer>> value = map.get(j);
                    List<List<Integer>> Cn_1k_1 = map.get(j-1);
                    for(List<Integer> list : Cn_1k_1) {
                        List<Integer> addList = new ArrayList<>(list);
                        addList.add(i);
                        value.add(addList);
                    }
                }
            }
        }
        return map.get(k);
    }
}
// @lc code=end

