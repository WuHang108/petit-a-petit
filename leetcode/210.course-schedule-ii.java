/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */
import java.util.*;

import javax.print.attribute.standard.NumberUpSupported;
// @lc code=start
class Solution {
    List<Integer>[] graph;
    boolean[] globalMarked;
    boolean[] localMarked;
    Stack<Integer> stack;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new List[numCourses];
        for(int i=0; i<prerequisites.length; ++i) {
            if(graph[prerequisites[i][0]] == null) {
                graph[prerequisites[i][0]] = new ArrayList<>();
            }
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        globalMarked = new boolean[numCourses];
        localMarked = new boolean[numCourses];
        stack = new Stack<>();
        for(int i=0; i<numCourses; ++i) {
            if(isCycle(i)) {
                return new int[0];
            }
        }
        int[] order = new int[numCourses];
        for(int i=numCourses-1; i>=0; i--) {
            order[i] = stack.pop();
        }
        return order;
    }

    boolean isCycle(int course) {
        if(localMarked[course]) return true;
        if(globalMarked[course]) return false;
        globalMarked[course] = true;
        localMarked[course] = true;
        if(graph[course]!=null)for(int pre : graph[course]) {
            if(isCycle(pre)) {
                return true;
            }
        }
        localMarked[course] = false;
        stack.push(course);
        return false;
    }
}
// @lc code=end

