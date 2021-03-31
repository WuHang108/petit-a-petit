import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> path = new LinkedList<>();
        if (root == null) return path;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pointer = root;
        while(pointer!=null | !stack.empty()) {
            while(pointer != null) {
                stack.push(pointer);
                pointer = pointer.left;
            }
            TreeNode node = stack.pop();
            path.add(node.val);
            pointer = node.right;
        }
        return path;
    }
}
// @lc code=end

