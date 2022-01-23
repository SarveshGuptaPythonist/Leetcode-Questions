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
    public ListNode detectCycle(ListNode head) {
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
}
