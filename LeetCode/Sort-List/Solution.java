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
12    public ListNode sortList(ListNode head) {
13        if (head == null) {
14            return null;
15
16        }
17        ListNode cur = head;
18
19        PriorityQueue <ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
20        while (cur != null) {
21            pq.offer(cur);
22            cur = cur.next;
23
24        }
25
26        ListNode dummy = new ListNode(-1);
27        ListNode tail = dummy;
28        while (!pq.isEmpty()) {
29            ListNode poll = pq.poll();
30            tail.next = poll;
31            tail = tail.next;
32
33        }
34        tail.next = null;
35        return dummy.next;
36        
37        
38    }
39}