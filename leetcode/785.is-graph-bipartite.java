import java.util.HashSet;

/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    int[] parent;

    int findParent(int i_point) {
        if(parent[i_point] == i_point) return i_point;
        return parent[i_point] = findParent(parent[i_point]);
    }

    public boolean isBipartite(int[][] graph) {
        int num_points = graph.length;
        parent = new int[num_points];
        for(int i=0; i<parent.length; ++i) {
            parent[i] = i;
        }
        int modify = 0;
        for(int i=0; i<num_points; ++i) {
            parent[i] = findParent(i);
            if(graph[i].length==0) {modify++;}
            for(int j=1; j<graph[i].length; ++j) {
                if(findParent(graph[i][j]) != findParent(graph[i][0])){
                    parent[parent[graph[i][j]]] = parent[graph[i][0]];
                }
            }
        }
        for(int i=0; i<num_points; ++i) {
            parent[i] = findParent(i);
        }
        // one or more parent
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0; i<parent.length; ++i) {
            hashSet.add(parent[i]);
        }
        if(hashSet.size()-modify >= 2) return true;
        return false;
    }
}
// @lc code=end

