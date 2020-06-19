/*
 * @lc app=leetcode id=605 lang=java
 *
 * [605] Can Place Flowers
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i=0;
        if(n == 0) return true;
        if(flowerbed.length==1){
            if(n<=1 && flowerbed[i]==0) return true;
            return false;
        }
        if(flowerbed[0]==0 && flowerbed[1]==0) {
            --n;
            flowerbed[0]=1;
        }
        for(i=1; i<flowerbed.length-1; ++i){
            if(flowerbed[i-1]==0&&flowerbed[i]==0&&flowerbed[i+1]==0){
                flowerbed[i] = 1;
                --n;
            }
        }
        if(flowerbed.length>1&&flowerbed[i-1]==0 && flowerbed[i]==0){
            flowerbed[i]=1;
            --n;
        }
        if(n<=0) return true;
        return false;
    }
}
// @lc code=end

