/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode b = before,a = after;
        while(head != null){
            if(head.val < x){
                b.next = head;
                b = b.next;
            }else{
                a.next = head;
                a = a.next;
            }
            head = head.next;
        }
        a.next = null;
        b.next = after.next;
        
        
        return before.next;
    }
}
