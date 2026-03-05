1/**
2 * Definition for singly-linked list.
3 * class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public boolean hasCycle(ListNode head) {
14        if (head == null) {
15            return false;
16        }
17        ListNode slow = head;
18        ListNode fast = head;
19        while (fast != null && fast.next != null ) {
20            slow = slow.next;
21            fast = fast.next.next;
22            if (slow == fast) {
23                return true;
24            }
25        }
26        return false;
27        
28    }
29}