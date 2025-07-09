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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);

        ListNode small_curr = small;
        ListNode large_curr = large;

        while(head!=null){
            if(head.val<x){
                small.next = head;
                small = small.next;
                head = head.next;
                small.next = null;
            }else{
                large.next=head;
                large = large.next;
                head = head.next;
                large.next=null;
            }
        }
        small.next = large_curr.next;
        return small_curr.next;
    }
}