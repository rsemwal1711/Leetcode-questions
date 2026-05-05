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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode tail = head;
        while(tail.next!=null){
            len++;
            tail = tail.next;
        }
        ListNode temp = head;
        k = k%len;
        if(k == 0) return head;
        for(int i=0;i<len-k-1;i++){
            temp = temp.next;
        }
        ListNode newHead = temp.next;
        tail.next = head;
        head = newHead;
        temp.next = null;
        return head;
    }
}