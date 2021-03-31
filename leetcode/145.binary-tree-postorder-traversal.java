import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> path = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(! stack.empty()) {
            TreeNode node = stack.pop();
            if(null == node) continue;
            path.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(path);
        return path;
    }
}
// @lc code=end

