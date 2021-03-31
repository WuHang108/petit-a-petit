/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */
import java.util.*;
// @lc code=start
class Solution {
    List<Integer>[] graph;
    boolean[] globalMarked;
    boolean[] localMarked;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new List[numCourses];
        for(int i=0; i<prerequisites.length; ++i) {
            if(graph[prerequisites[i][0]] == null) {
                graph[prerequisites[i][0]] = new ArrayList<>();
            }
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        globalMarked = new boolean[numCourses];
        localMarked = new boolean[numCourses];
        for(int i=0; i<numCourses; ++i) {
            if(isCycle(i)) {
                return false;
            }
        }
        return true;
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
        return false;
    }
}
// @lc code=end

