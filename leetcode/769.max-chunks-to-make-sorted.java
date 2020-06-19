/*
 * @lc app=leetcode id=769 lang=java
 *
 * [769] Max Chunks To Make Sorted
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int pivot = 0;
        int res = 0;
        while(pivot < arr.length){
            for(int i=pivot+1; i<=arr[pivot]; ++i){
                if(arr[pivot] < arr[i]){
                    pivot = i;
                    continue;
                }
            }
            ++res;
            pivot = arr[pivot]+1;
        }
        return res;
    }
}
// @lc code=end

