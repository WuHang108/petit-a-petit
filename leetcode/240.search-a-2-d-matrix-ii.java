import java.util.Queue;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

class Main {
    public static void main(String[] args) {
        // Create a new Solution instance
        Solution solution = new Solution();
        // Create a test case
        int testCase[][] = {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30}
        };
        // Get the answer
        boolean answer = solution.searchMatrix(testCase, 20);
        // Print the answer
        System.out.println(answer);
    }
}

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int X = matrix.length;
        if (X<=0) return false;
        int Y = matrix[0].length;
        int[][] mat = new int[X+2][Y+2];
        boolean[][] done = new boolean[X+2][Y+2];
        for(int i=0; i<X+2; ++i) for(int j=0; j<Y+2; ++j){
            if (i==0 || i==X+1 || j==0 || j==Y+1){
                mat[i][j] = Integer.MAX_VALUE;
                done[i][j] = true;
            } else {
                mat[i][j] = matrix[i-1][j-1];
                done[i][j] = false;
            }
        }
        Queue<Integer> candidates = new LinkedList<Integer>();
        candidates.add(1);  // x=1
        candidates.add(1);  // y=1
        while (candidates.isEmpty() == false){
            int x=candidates.remove();
            int y=candidates.remove();
            if(mat[x][y] == target) return true;
            if(done[x][y] == false){
                done[x][y] = true;
            } else continue;
            if (target == mat[x+1][y] || target == mat[x][y+1]){
                return true;
            } else if(target>mat[x+1][y] && target>mat[x][y+1] &&
                    mat[x+1][y]>mat[x][y+1] && done[x+1][y] == false){
                ++x;
            } else if(target>mat[x+1][y] && target>mat[x][y+1] &&
                    done[x][y+1] == false){
                ++y;
            } else if(target>mat[x+1][y] && target<mat[x][y+1] &&
                    done[x+1][y] == false){
                ++x;
            } else if(target<mat[x+1][y] && target>mat[x][y+1] &&
                    done[x][y+1] == false){
                ++y;
            } else { // edge moving and might bifurcate
                if (mat[x+1][y-1]<=target && done[x+1][y-1]==false){
                    candidates.add(x+1);
                    candidates.add(y-1);
                } else if(mat[x][y-1]<=target && done[x][y-1]==false){
                    candidates.add(x);
                    candidates.add(y-1);
                }
                if (mat[x-1][y+1]<=target && done[x-1][y+1]==false){
                    candidates.add(x-1);
                    candidates.add(y+1);
                } else if(mat[x-1][y]<=target && done[x-1][y]==false){
                    candidates.add(x-1);
                    candidates.add(y);
                }
                continue;
            }
            candidates.add(x);
            candidates.add(y);
        }
        return false;
    }
}
// @lc code=end
