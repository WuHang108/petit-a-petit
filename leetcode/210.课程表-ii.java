import java.util.*;
/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
class Solution {
    List<Integer>[] graph;
    Stack<Integer> postOrder;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return null;
        if(numCourses == 1) return new int[]{0};
        int[] res = new int[numCourses];
        graph = new List[numCourses];
        for(int i=0; i<numCourses; ++i) {
            graph[i] = new ArrayList<>();
        }
        for(int[] pre : prerequisites) {
            graph[pre[0]].add(pre[1]);
        }
        postOrder = new Stack<>();
        boolean[] globalMarked = new boolean[numCourses];
        boolean[] localMarked = new boolean[numCourses];
        for(int i=0; i<numCourses; ++i) {
            if(hasCycle(globalMarked, localMarked, i)) {
                return new int[0];
            }
        }
        for(int i=numCourses-1; !postOrder.empty()||i>=0; --i) {
            res[i] = postOrder.pop();
        }
        return res;
    }

    boolean hasCycle(boolean[] globalMarked, boolean[] localMarked, int index) {
        if(localMarked[index]) { return true;}
        if(globalMarked[index]) { return false;}
        globalMarked[index] = true;
        localMarked[index] = true;
        for(int node : graph[index]) {
            if(hasCycle(globalMarked, localMarked, node)) {
                return true;
            }
        }
        localMarked[index] = false;
        postOrder.push(index);
        return false;
    }
}
// @lc code=end

