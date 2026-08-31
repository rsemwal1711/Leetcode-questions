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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return new int[]{-1, -1};
        }
        List<Integer> list = new ArrayList<>();
        ListNode temp = head.next;
        ListNode prev = head;
        int i = 1;
        int cnt = 0;
        while(temp.next != null){
            if((temp.val > prev.val && temp.val > temp.next.val) || (temp.val < prev.val && temp.val < temp.next.val)){
                cnt++;
                list.add(i + 1);
            }
            prev = temp;
            temp = temp.next;
            i++;
        }
        if(cnt < 2) return new int[]{-1, -1};
        int first = Integer.MAX_VALUE;
        for(int j=1;j<list.size();j++){
            first = Math.min(first, list.get(j) - list.get(j-1));
        }
        int second = list.get(list.size() - 1) - list.get(0);
        return new int[]{first, second};
    }
}