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
    public int getLength(ListNode node) {
        int dist = 0;
        while(node != null) {
            dist++;
            node = node.next;
        }
        return dist;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int alen = getLength(headA);
        int blen = getLength(headB);
        int diff = blen - alen;
        if(alen > blen) {
            for(int i = 0; i < alen - blen; i++) {
                headA = headA.next;
            }
        }
        else{
            for(int i = 0; i < blen - alen; i++) {
                headB = headB.next;
            }
        }
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
