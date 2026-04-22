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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode temp = head;
        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while(l1 != null){
            st1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            st2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;
        while(!st1.isEmpty() || !st2.isEmpty()){
            int val1 = st1.isEmpty() ? 0 : st1.pop();
            int val2 = st2.isEmpty() ? 0 : st2.pop();
            int sum = val1 + val2 + carry;
            carry = sum/10;
            int ans = sum % 10;
            temp.next = new ListNode(ans);
            temp = temp.next;
        }
        if(carry != 0){
            temp.next = new ListNode(carry);
        }
        return reverse(dummy.next);
    }
}