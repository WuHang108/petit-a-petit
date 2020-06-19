/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 */
import java.util.*;
// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if(root==null) return res;
        List<String> sublist = binaryTreePaths(root.left);
        List<String> sublist2 = binaryTreePaths(root.right);
        if (sublist.size() > 0) for(String sub:sublist){
            String lstr = String.valueOf(root.val) + "->" + sub;
            res.add(lstr);
        }
        if (sublist2.size() > 0) for(String sub:sublist2){
            String rstr = String.valueOf(root.val) + "->" + sub;
            res.add(rstr);
        } else if(sublist.size()==0) {
                res.add(String.valueOf(root.val));
        }
        return res;
    }
}
// @lc code=end

