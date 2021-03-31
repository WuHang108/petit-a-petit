/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    Integer prev_val;

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if (isValidBST(root.left) == false){
            return false;
        }
        if (prev_val != null && prev_val >= root.val) {
            return false;
        }
        prev_val = root.val;
        return isValidBST(root.right);
    }
}
// @lc code=end

