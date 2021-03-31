/*
 * @lc app=leetcode.cn id=814 lang=java
 *
 * [814] 二叉树剪枝
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {return null;}
        if(pruneTree(root.left) == null){
            root.left = null;
        }
        if(pruneTree(root.right) == null) {
            root.right = null;
        }
        if(root.left==null && root.right==null && root.val == 0) {
            root = null;
        }
        return root;
    }
}
// @lc code=end

