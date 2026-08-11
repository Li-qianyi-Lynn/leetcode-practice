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
12    public ListNode mergeKLists(ListNode[] lists) {
13        if (lists.length == 0) {
14            return null;
15
16        }
17        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
18        for (ListNode n : lists) {
19            ListNode cur = n;
20            while (cur != null) {
21                pq.offer(cur);
22                cur = cur.next;
23            }
24        }
25
26        ListNode dummy = new ListNode(-1);
27        ListNode tail = dummy;
28
29        while (!pq.isEmpty()) {
30            ListNode poll = pq.poll();
31            tail.next = poll;
32            tail = tail.next;
33        }
34        tail.next = null;
35        return dummy.next;
36
37        
38    }
39}