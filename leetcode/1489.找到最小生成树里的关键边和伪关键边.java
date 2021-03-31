import java.util.*;

/*
 * @lc app=leetcode.cn id=1489 lang=java
 *
 * [1489] 找到最小生成树里的关键边和伪关键边
 */

// @lc code=start
class Solution {
    List<Integer> criticalEdges;
    List<Integer> qseudoEdges;
    int[] par;

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<int[]> graph = new ArrayList<>();
        for(int i=0; i<edges.length; ++i) {
            int[] edgeInfo = new int[4]; // index, from, to, weight
            edgeInfo[0] = i;
            edgeInfo[1] = edges[i][0];
            edgeInfo[2] = edges[i][1];
            edgeInfo[3] = edges[i][2];
            graph.add(edgeInfo);
        }
        graph.sort(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[3] - o2[3];
            }
        });
        // for(int[] edge : graph) {
        //     System.out.printf("index:%d; from:%d; to:%d; w:%d\n", edge[0], edge[1], edge[2], edge[3]);
        // }
        par = new int[n];
        initSet(n);
        int benchmark = findMSTWeight(graph);

        criticalEdges = new ArrayList<>();
        for(int i=0; i<graph.size(); ++i) {
            List<int[]> tempEdges = new ArrayList<>(graph);
            int[] removed_edge = tempEdges.remove(i);
            initSet(n);
            if(benchmark != findMSTWeight(tempEdges)) {
                criticalEdges.add(removed_edge[0]);
            }
        }
        qseudoEdges = new ArrayList<>();
        for(int i=0; i<graph.size(); ++i) {
            List<int[]> tempEdges = new ArrayList<>(graph);
            int[] test_edge = tempEdges.remove(i);
            if (! criticalEdges.contains(test_edge[0])) {
                initSet(n);
                join(test_edge[1], test_edge[2]);
                if(benchmark == test_edge[3]+findMSTWeight(tempEdges)) {
                    qseudoEdges.add(test_edge[0]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(criticalEdges);
        ans.add(qseudoEdges);
        return ans;
    }

    int findMSTWeight(List<int[]> edges) {
        int w_tree = 0;
        for(int[] edge : edges) {
            if(findPar(edge[1]) != findPar(edge[2])) {
                join(edge[1], edge[2]);
                w_tree += edge[3];
            }
            
        }
        return w_tree;
    }

    int findPar(int edge) {
        if(par[edge] == edge) {return edge;}
        return par[edge] = findPar(par[edge]);
    }

    void join(int a, int b) {
        while(findPar(a) != findPar(b)) {
            par[par[a]] = findPar(b);
        }
    }

    void initSet(int n) {
        for(int i=0; i<n; ++i) {
            par[i] = i;
        }
    }
}
// @lc code=end

