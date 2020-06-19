/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */
import java.util.*;
// @lc code=start
class Solution {
    int[] xdir = {1,0,-1, 0};
    int[] ydir = {0,1, 0,-1};
    int dfs(int[][] mat, int x, int y, boolean[][] done, int area){
        if(mat[x][y]==1 && done[x][y]==false){
            done[x][y] = true;
            area++;
            for(int i=0; i<4; ++i){
                area = dfs(mat, x+xdir[i], y+ydir[i], done, area);
            }
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxarea = 0;
        if(grid.length==0||grid[0].length==0) return maxarea;
        int[][] mat = new int[grid.length+2][grid[0].length+2];
        for(int i=1; i<=grid.length;++i) for(int j=1; j<=grid[0].length; ++j){
            mat[i][j] = grid[i-1][j-1];
        }
        boolean[][] done = new boolean[mat.length][mat[0].length];
        for(int x=1; x<=grid.length; ++x) for(int y=1; y<=grid[0].length; ++y){
            maxarea = Math.max(maxarea, dfs(mat,x,y,done,0));
        }
        return maxarea;
    }
}
// @lc code=end

