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
// here we are changing our listnode and making it a cycle and we then apply startpoint of cycle method
public class Solution {
    public ListNode hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return null;
        
        
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.println((slow == fast) == 1);
        return (slow == fast) ? slow : null;
    }
    public ListNode startPointOfCycle(ListNode head) {
        ListNode ptr1 = hasCycle(head);
        if(ptr1 == null) return null;
        if(ptr1 == head) return head;
        ListNode ptr2 = head;
        while(ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr2;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // this time I will create headB as a cycle 
        ListNode temp = headB;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = headB;
        ListNode ans = startPointOfCycle(headA);
        temp.next = null;
        return ans;
        
    }
}
