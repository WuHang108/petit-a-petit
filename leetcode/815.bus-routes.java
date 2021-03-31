/*
 * @lc app=leetcode id=815 lang=java
 *
 * [815] Bus Routes
 */
import java.util.*;
// @lc code=start
class Solution {
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    HashMap<Integer, Boolean> searched = new HashMap<>();
    class Pair{
        public int k;
        public int v;
        public Pair(int point, int dist) {
            k = point;
            v = dist;
        }
    }
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.v - o2.v;
        }
    });
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        for(int i=0; i<routes.length; ++i) {
            graph.put(i, new ArrayList<Integer>());
            searched.put(i, false);
        }
        for(int i=0; i<routes.length; ++i) {
            for(int j=0; j<routes.length; ++j) {
                if(intersect(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        // find route of source and target
        for(int i=0; i<routes.length; ++i) {
            if(Arrays.binarySearch(routes[i], source)>=0) {
                Pair pair = new Pair(i, 0);
                searched.put(i, true);
                pq.add(pair);
            }
        }

        int min = Integer.MAX_VALUE;
        while(!pq.isEmpty()) {
            Pair out = pq.poll();
            searched.put(out.k, true);
            if(Arrays.binarySearch(routes[out.k], target)>=0) {
                min = Math.min(min, out.v+1);
            }
            ArrayList<Integer> neighbors = graph.get(out.k);
            int dist = out.v;
            for(int route : neighbors) if(!searched.get(route)) {
                pq.add(new Pair(route, dist+1));
                searched.put(route, true);
            }
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }

    public boolean intersect(int[] A, int[] B) {
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) return true;
            if (A[i] < B[j]) i++; else j++;
        }
        return false;
    }
}
// @lc code=end

