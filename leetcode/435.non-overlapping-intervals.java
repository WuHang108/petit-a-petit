import java.util.Arrays;
import java.util.Collections;
/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    class Pair implements Comparable {
        public int start;
        public int end;
        public Pair(){}
        public Pair(int s, int e){
            start = s;
            end = e;
        }
        public int compareTo(Object o){
            Pair p = (Pair)o;
            if(this.end < p.end){
                return -1;
            }else if(this.end == p.end){
                if(this.start > p.start) return -1;
                else if(this.start < p.start) return 1;
                return 0;
            }
            return 1;
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        if(intervals.length == 0) return 0;
        Pair[] input = new Pair[intervals.length];
        for(int i=0; i<intervals.length; ++i){
            input[i] = new Pair(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(input);

        int end = Integer.MIN_VALUE;
        for(int i=0; i<input.length; ++i){
            if(input[i].end > end && input[i].start >= end){
                end = input[i].end;
                ++ res;
            }
        }
        return input.length-res;
    }
}
// @lc code=end

