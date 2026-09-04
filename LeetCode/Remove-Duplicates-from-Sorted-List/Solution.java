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
13        
14
15        ListNode cur = head;
16        
17        while (cur != null && cur.next != null) {
18            if (cur.val == cur.next.val) {
19                cur.next = cur.next.next;
20
21            } else {
22                cur = cur.next;
23            }
24
25        }
26        return head;
27        
28    }
29}
30
31/**
32       1 -> 1 -> 2 -> 3 -> 3
33     prev
34                 cur
35
36dummy ->  1 -> 2 ->3
37prev
38 */