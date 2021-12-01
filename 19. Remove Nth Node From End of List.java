// Method 1 - THis method also runs but technically we are not removing the node just changing the pointers
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1) {return null;}
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if(fast == null) {
            return head.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
                           
        
    }
}

// IN Mehtod 2 we are also changing deleting and updating the pointer.

// class Solution {
//   public ListNode removeNthFromEnd(ListNode head, int n) {
//     if (head == null) {
//       return head;
//     }
//     ListNode fast = head;
//     ListNode slow = head;
//     // while (n-- > 0) {
//     //   fast = fast.next;
//     // }
//     for(int i = 0; i < n; i++) {
//             fast = fast.next;
//         }
//     if (fast == null) {
//       ListNode next = head.next;
//       head.next = null;
//       return next;
//     }
//     while (fast.next != null) {
//       fast = fast.next;
//       slow = slow.next;
//     }
//     ListNode next = slow.next;
//     ListNode forw = next.next;
//     next.next = null;
//     slow.next = forw;

//     return head;
//   }
// }
