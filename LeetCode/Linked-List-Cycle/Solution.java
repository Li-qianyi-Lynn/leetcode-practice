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
14        if (head == null || head.next == null) return false;
15
16        ListNode fast = head;
17        ListNode slow = head;
18        while (fast!= null && fast.next != null) {
19            slow = slow.next;
20            fast = fast.next.next;
21
22            if (fast == slow) {
23                return true;
24            }
25
26        }
27        return false;
28
29       
30    }
31}