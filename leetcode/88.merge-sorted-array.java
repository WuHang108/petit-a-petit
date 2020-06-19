/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums0 = new int[m];
        for(int i=0;i<m;++i) nums0[i]=nums1[i];
        int i0=0, i1=0, i2=0;
        while(i0<m && i2<n){
            if(nums0[i0] < nums2[i2]){
                nums1[i1++] = nums0[i0++];
            } else {
                nums1[i1++] = nums2[i2++];
            }
        }
        while(i0 < m){
            nums1[i1++] = nums0[i0++];
        }
        while(i2<n){
            nums1[i1++] = nums2[i2++];
        }
    }
}
// @lc code=end

