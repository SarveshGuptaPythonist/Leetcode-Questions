/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(0);
        ListNode temp = curr;
        while(l1 != null || l2 != null) {
            int a = l1 != null ? l1.val:0;
            int b = l2 != null ? l2.val:0;
            int total = a + b + curr.val;
            int carry = total / 10;
            total %= 10;
            
            curr.val = total;
            l1 = l1 != null ? l1.next:null;
            l2 = l2 != null ? l2.next:null;
            // curr.next = new ListNode(carry);
            //     curr = curr.next;
            if(l1 != null || l2 != null || carry==1){
                curr.next = new ListNode(carry);
                curr = curr.next;
            }
            
        }
        return temp;
    }
}



// 3 4 5 6
// 7 8 9



//   1 1 1 1 1 1 1
// 9 9 9 9 9 9 9 0
// 9 9 9 9 0 0 0 0
// -----------------
// 8 9 9 9 0 0 0 1
