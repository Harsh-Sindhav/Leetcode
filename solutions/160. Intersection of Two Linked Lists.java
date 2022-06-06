/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lena = length(headA);
        int lenb = length(headB);
        
        if(lena > lenb){
            int diff = lena - lenb;
            while(headA != null && diff > 0){
                headA = headA.next;
                diff--;
            }
        }else{
              int diff = lenb - lena;
              while(headB != null && diff > 0){
                headB = headB.next;
                  diff--;
            }
        }
        // System.out.print(headA.val + " " + headB.val);
        while(headA != null && headB != null)
        {
            if(headA == headB) return headA;
            
            headA = headA.next;
            headB = headB.next;
            
        }
        
            
            return null;
    }
    
    int length(ListNode head){
        if(head == null) return 0;
        int count  = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
}
