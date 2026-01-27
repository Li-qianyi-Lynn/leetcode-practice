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
17
18        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
19        for (ListNode list : lists) {
20            ListNode cur = list;
21            while (cur != null) {
22                pq.offer(cur);
23                cur = cur.next;
24            }
25
26        }
27
28        ListNode dummy = new ListNode(-1);
29        ListNode tail = dummy;
30        while (!pq.isEmpty()) {
31            ListNode poll = pq.poll();
32            tail.next = poll;
33            tail = tail.next;
34
35        }
36        tail.next = null;
37        return dummy.next;
38    }
39}
40
41/**
42iterate list，put all node into pq;
43build result
44
45
46 */