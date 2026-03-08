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
11public class Solution {
12    public ListNode reverseBetween(ListNode head, int left, int right) {
13        ListNode dummy = new ListNode(0);
14        dummy.next = head;
15        ListNode leftPrev = dummy, cur = head;
16
17        for (int i = 0; i < left - 1; i++) {
18            leftPrev = cur;
19            cur = cur.next;
20        }
21
22        ListNode prev = null;
23        for (int i = 0; i < right - left + 1; i++) {
24            ListNode tmpNext = cur.next;
25            cur.next = prev;
26            prev = cur;
27            cur = tmpNext;
28        }
29
30        leftPrev.next.next = cur;
31        leftPrev.next = prev;
32
33        return dummy.next;
34    }
35}