1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode deleteMiddle(ListNode head) {
13        // edge case
14        if (head.next == null) {
15            return null;
16        }
17
18        // step1: get the middle node -> pre ,next
19        ListNode slow = head;
20        ListNode fast = head;
21        ListNode pre = head;
22        while (fast != null && fast.next != null) {
23            pre = slow;
24            slow = slow.next;
25            fast = fast.next.next;
26        }
27        // connext pre and next
28        ListNode nex = slow.next;
29        pre.next = nex;
30        return head;
31        
32    }
33}
34/**
35input： head of a linkedlist
36output: head of a linkedlist(delete the middle node)
37to find the middle node and connect the first part with the second part
38
39prev
40next
41
42
43
44
45 */