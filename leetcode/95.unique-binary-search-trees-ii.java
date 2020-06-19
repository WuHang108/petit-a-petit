/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
 */

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
    List<TreeNode> genSubTrees(int left, int right){
        List<TreeNode> res = new LinkedList<>();
        if(left == right){
            res.add(new TreeNode(left));
        } else { 
            for(int i=left;i<=right;++i){
                if(i==left){
                    List<TreeNode> rightTrees = genSubTrees(i+1,right);
                    for(TreeNode rnode:rightTrees){
                        TreeNode head = new TreeNode(left);
                        head.right = rnode;
                        res.add(head);
                    }
                } else if(i==right){
                    List<TreeNode> leftTrees = genSubTrees(left,i-1);
                    for(TreeNode lnode:leftTrees){
                        TreeNode head = new TreeNode(right);
                        head.left = lnode;
                        res.add(head);
                    }
                } else {
                    List<TreeNode> leftTrees = genSubTrees(left,i-1);
                    List<TreeNode> rightTrees = genSubTrees(i+1,right);
                    for(TreeNode lnode:leftTrees) for(TreeNode rnode:rightTrees){
                        TreeNode head = new TreeNode(i);
                        head.left = lnode;
                        head.right = rnode;
                        res.add(head);
                    }
                }
            }
        }
        return res;
    }
    public List<TreeNode> generateTrees(int n) {
        return genSubTrees(1,n);
    }
}
// @lc code=end

