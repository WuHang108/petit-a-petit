/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 */
import java.util.*;
// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1=l1, p2=l2;
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(p1!=null && p2!=null){
            if(p1.val > p2.val){
                p.next = new ListNode(p2.val);
                p2 = p2.next;
            } else {
                p.next = new ListNode(p1.val);
                p1 = p1.next;
            }
            p = p.next;
        }
        while(p1 != null){
            p.next = new ListNode(p1.val);
            p1 = p1.next; p = p.next;
        }
        while(p2 != null){
            p.next = new ListNode(p2.val);
            p2 = p2.next; p = p.next;
        }
        return head.next;
    }
}
// @lc code=end

