class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode ltail = left, rtail = right;
        ListNode temp = head;
        
        while(temp != null) {
            int curr = temp.val;
            if(curr < x) {
                ltail.next = temp;
                ltail = temp;
            }
            else {
                rtail.next = temp;
                rtail = temp;
            }
            temp = temp.next;
        }
        ltail.next = right.next;
        rtail.next = null;
        return left.next;
    }
}
