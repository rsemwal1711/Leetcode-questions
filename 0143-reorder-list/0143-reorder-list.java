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
    public int len(ListNode head){
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
    public void reorderList(ListNode head) {
        int len = len(head);
        if(len == 0 || len == 1) return;
        Queue<ListNode> q = new LinkedList<>();
        Stack<ListNode> st = new Stack<>();
        int i=0;
        while(head != null){
            if(i < len/2){
                q.offer(head);
            }
            else{
                st.push(head);
            }
            i++;
            head = head.next;
        }
        head = null;
        head = q.poll();
        ListNode temp = head;
        i=1;
        while(!q.isEmpty() && !st.isEmpty()){
            if(i % 2 == 1){
                temp.next = st.pop();
            }
            else{
                temp.next = q.poll();
            }
            i++;
            temp = temp.next;
        }
        while(!q.isEmpty()){
            temp.next = q.poll();
            temp = temp.next;
        }
        while(!st.isEmpty()){
            temp.next = st.pop();
            temp = temp.next;
        }
        temp.next = null;
    }
}