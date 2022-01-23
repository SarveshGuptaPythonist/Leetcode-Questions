public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return false;
        
        
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return (slow == fast);
    }
}
