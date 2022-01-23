class Solution
{
    static public Node hasCycle(Node head) {
        if(head == null || head.next == null || head.next.next == null) return null;
        
        
        Node slow = head.next;
        Node fast = head.next.next;
        while(fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.println((slow == fast) == 1);
        return (slow == fast) ? slow : null;
    }
    static public Node startPointOfCycle(Node head) {
        Node ptr1 = hasCycle(head);
        if(ptr1 == null) return null;
        if(ptr1 == head) return head;
        Node ptr2 = head;
        while(ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr2;
    }
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        //Add your code here.
        Node start = startPointOfCycle(head);
        if(start == null) return 0;
        Node temp = start.next;
        int count = 1;
        while(temp != start) {
            count++;
            temp = temp.next;
        }
        return count;
        
    }
}
