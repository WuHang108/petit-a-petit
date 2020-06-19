/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        boolean[] iscomposite = new boolean[n];
        for(int i=2;i<n;i++){
            int j = i;
            if(iscomposite[j] == false){
                for(j=i+i;j<n;j+=i){
                    iscomposite[j] = true;
                }
            }
        }
        int res = 0;
        for(int i=2; i<n; ++i){
            if(iscomposite[i] == false) ++res;
        }
        return res;
    }
}
// @lc code=end

