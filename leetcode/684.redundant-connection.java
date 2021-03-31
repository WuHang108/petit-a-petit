/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int num_nodes = edges.length;
        parent = new int[num_nodes+1];
        for(int i=1; i<=num_nodes; i++)
            parent[i] = i;
        for(int i=0; i<num_nodes; ++i) {
            int[] edge = edges[i];
            if(isUnion(edge[0], edge[1])) return edge;
            parent[parent[edge[1]]] = unionFind(edge[0]);
        }
        return new int[0];
    }

    boolean isUnion(int u, int v) {
        return unionFind(u) == unionFind(v);
    }

    int unionFind(int node) {
        if(parent[node] == node) return node;
        return parent[node] = unionFind(parent[node]);
    }
}
// @lc code=end

