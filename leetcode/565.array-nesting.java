import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
/*
 * @lc app=leetcode id=565 lang=java
 *
 * [565] Array Nesting
 */

// @lc code=start
class Solution {
    int[] par;

    int find(int x) {
        if(par[x] == x) return x;
        return par[x] = find(par[x]);
    }

    public int arrayNesting(int[] nums) {
        int max_len = 0;
        par = new int[nums.length];
        for(int i=1; i<nums.length; ++i){
            par[i] = i; // init union find set
        }
        for(int i=0; i<nums.length; ++i){
            int len = 0;
            int j = i;
            if (i==0){
                do {
                    par[nums[j]] = find(j);
                    j = nums[j];
                    ++len;
                }while (nums[j] != nums[i]);
            } else if(find(nums[i]) != find(nums[0])){
                len = 0;
                while(find(nums[j]) != find(nums[0])){
                    par[nums[j]] = find(nums[0]);
                    j = nums[j];
                    ++ len;
                }
            }
            if (len>max_len){
                max_len = len;
            }
        }
        return max_len;
    }
}
// @lc code=end

