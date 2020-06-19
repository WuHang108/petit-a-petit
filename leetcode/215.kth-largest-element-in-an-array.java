import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        for(int e:nums){
            heap.add(e);
        }
        for(int i=0; i<k-1; ++i){
            heap.poll();
        }
        return heap.poll();
    }
}
// @lc code=end

