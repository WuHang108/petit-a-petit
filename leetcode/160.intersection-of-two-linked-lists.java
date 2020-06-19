/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        boolean flag1 = false;
        ListNode p2 = headB;
        boolean flag2 = false;
        while(p1 != p2){
            if(p1 ==null){
                if(flag1 == false){
                    p1 = headB;
                    flag1 = true;
                } else {
                    return null;
                }
            } else {
                p1 = p1.next;
            }
            if(p2 == null){
                if(flag2 == false){
                    p2 = headA;
                    flag2 = true;
                } else {
                    return null;
                }
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
// @lc code=end

