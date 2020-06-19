
/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */
import java.util.Queue;
import java.util.LinkedList;

// @lc code=start
class Solution {
    final int[] xdir = {1,1,0,-1,-1,-1, 0, 1};
    final int[] ydir = {0,1,1, 1, 0,-1,-1,-1};
    class Pair{
        int first;
        int second;
        int depth;
        Pair(int f,int s, int d){
            first=f;second=s;depth = d;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Pair> candidates = new LinkedList<Pair>();
        int N = grid.length;
        boolean[][] done = new boolean[grid.length][grid[0].length];
        if(grid[0][0]==1 || grid[N-1][N-1]==1) return -1;
        candidates.add(new Pair(N-1,N-1,0));
        done[N-1][N-1] = true;
        while(candidates.isEmpty()==false){
            Pair point = candidates.remove();
            int depth = point.depth;
            if(point.first==0&&point.second==0)
                return point.depth+1;
            for(int i=0;i<8;++i){
                int xn = point.first + xdir[i];
                int yn = point.second + ydir[i];
                if(xn>=0&&xn<N&&yn>=0&&yn<N&&done[xn][yn]==false&&grid[xn][yn]==0){
                    candidates.add(new Pair(xn,yn,depth+1));
                    done[xn][yn] = true;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

