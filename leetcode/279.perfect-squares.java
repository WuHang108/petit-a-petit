/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */
import java.util.*;
// @lc code=start
class Solution {
    class Node {
        int num;
        List<Node> neighbors;
        Node(){ neighbors = new LinkedList<>();}
    }
    public int numSquares(int n) {
        Node[] nodes = new Node[n+1];
        // graph building
        for(int i=0;i<=n;i++){
            nodes[i] = new Node();
            nodes[i].num = i;
            if(i>0) nodes[i-1].neighbors.add(nodes[i]);
        }
        int j=1;
        while(++j<n) for(int i=0;i<=n;++i){
            int iplus = i+j*j;
            if(iplus > n) break;
            nodes[i].neighbors.add(nodes[iplus]);
        }
        // bfs
        Queue<LinkedList<Integer>> searching = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        searching.add(path);
        boolean[] done = new boolean[n+1];
        done[0] = true;
        while(searching.isEmpty() == false){
            path = searching.remove();
            int index = path.get(0); // 当前位置放在0位
            if(index == n) break;
            for(Node p:nodes[index].neighbors){
                if(done[p.num] == false){
                    LinkedList<Integer> newpath = new LinkedList<>(path);
                    newpath.addFirst(p.num);
                    done[p.num] = true;
                    searching.add(newpath);
                }
            }
        }
        return path.size()-1;
    }
}
// @lc code=end

