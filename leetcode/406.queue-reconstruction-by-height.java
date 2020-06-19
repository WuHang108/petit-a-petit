/*
 * @lc app=leetcode id=406 lang=java
 *
 * [406] Queue Reconstruction by Height
 */
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
// @lc code=start
class Solution {
    class Sortbyheight implements Comparator<int[]> 
    { 
        // Used for sorting in ascending order
        public int compare(int[] a, int[] b) 
        {
            if(a[0]>b[0]){
                return -1;
            } else if(a[0]<b[0]){
                return 1;
            } else {
                return a[1]-b[1];
            }
        } 
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Sortbyheight());
        List<int[]> res = new LinkedList<>();
        for(int i=0; i<people.length; ++i){
            if(i==0){
                res.add(people[0]);
            } else {
                res.add(people[i][1], people[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end

