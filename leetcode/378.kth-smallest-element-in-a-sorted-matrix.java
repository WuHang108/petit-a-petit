import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
class Solution {
    class Point {
        int x;
        int y;
        int val;
        public Point(int _x, int _y, int _val){
            x = _x;
            y = _y;
            val = _val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int X = matrix.length;
        int Y = matrix[0].length;
        boolean[][] done = new boolean[X][Y];
        Queue<Point> pQueue = new PriorityQueue<Point>(X*Y*4, new Comparator<Point>() {
            @Override
            public int compare(Point P1, Point P2){
                return P1.val - P2.val;
            }
        });
        int count = 0;
        Point P = new Point(0,0,matrix[0][0]);
        pQueue.offer(P);
        while (count < k){
            P = pQueue.poll();
            done[P.x][P.y] = true;
            if(P.x+1<X && done[P.x+1][P.y]==false){
                pQueue.offer(new Point(P.x+1, P.y, matrix[P.x+1][P.y]));
                done[P.x+1][P.y] = true;
            }
            if(P.y+1<Y && done[P.x][P.y+1]==false){
                pQueue.offer(new Point(P.x, P.y+1, matrix[P.x][P.y+1]));
                done[P.x][P.y+1] = true;
            }
            ++count;
        }
        return P.val;
    }
}
// @lc code=end

