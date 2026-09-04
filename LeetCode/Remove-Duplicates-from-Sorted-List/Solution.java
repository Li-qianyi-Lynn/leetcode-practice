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
12    public ListNode deleteDuplicates(ListNode head) {
13        if (head == null || head.next == null) {
14            return head;
15
16        }
17        ListNode dummy = new ListNode(-101);
18        ListNode prev = dummy;
19        ListNode cur = head;
20        while (cur != null) {
21            if (cur.val == prev.val) {
22                cur = cur.next;
23                
24
25            } else {
26                prev.next = cur;
27                prev = prev.next;
28                cur = cur.next;
29            }
30
31
32        }
33        prev.next = null;
34        return dummy.next;
35        
36    }
37}
38
39/**
40       1 -> 1 -> 2 -> 3 -> 3
41     prev
42                 cur
43
44dummy ->  1 -> 2 ->3
45prev
46 */