/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

// @lc code=start

// public class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) { val = x; }
// }

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        if(head == null) return head;
        ListNode post = head.next;
        while(post != null){
            current.next = pre;
            pre = current;
            current = post;
            post= post.next;
        }
        current.next = pre;
        return current;
    }
}
// @lc code=end

