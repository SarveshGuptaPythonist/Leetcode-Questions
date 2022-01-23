class GfG
{
    boolean isCircular(Node head)
    {
	// Your code here	
	if(head == null || head.next == null || head.next.next == null) return false;


        Node slow = head;
        Node fast = head.next.next;
        while(fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return (slow == fast);
    }
}
