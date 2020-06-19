import java.util.Arrays;
/*
 * @lc app=leetcode id=452 lang=java
 *
 * [452] Minimum Number of Arrows to Burst Balloons
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
                if(this.start < p.start) return -1;
                else if(this.start > p.start) return 1;
                return 0;
            }
            return 1;
        }
    }

    public int findMinArrowShots(int[][] points) {
        int res = 0;
        if (points.length == 0) return res;
        Pair[] input = new Pair[points.length];
        for(int i=0; i<points.length; ++i){
            input[i] = new Pair(points[i][0], points[i][1]);
        }
        Arrays.sort(input);
        int end = input[0].end;
        res = 1;
        for(int i=1; i<input.length; ++i){
            if(input[i].end > end && input[i].start > end){
                end = input[i].end;
                ++ res;
            }
        }
        return res;
    }
}
// @lc code=end

