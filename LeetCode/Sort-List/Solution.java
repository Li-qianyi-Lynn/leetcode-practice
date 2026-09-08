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
13        //1. split from the mid :divide and conquer
14        if (head == null || head.next == null) {
15            return head;
16        }
17        ListNode dummy = new ListNode(0);
18        ListNode pre = null;
19        ListNode slow = head;
20        ListNode fast = head;
21        while (fast != null && fast.next != null) {
22            pre = slow;
23            slow = slow.next;
24            fast = fast.next.next;
25        }
26
27        pre.next = null;
28        ListNode left = sortList(head);
29        ListNode right = sortList(slow);
30        return merge(left,right);
31   
32    }
33
34    private ListNode merge(ListNode node1, ListNode node2) {
35        ListNode dummy = new ListNode(0);
36        ListNode cur = dummy;
37        while (node1 != null && node2 != null) {
38            if (node1.val < node2.val) {
39                cur.next = node1;
40                node1 = node1.next;
41
42            } else {
43                cur.next = node2;
44                node2 = node2.next;
45
46            }
47            cur = cur.next;
48        }
49
50        if (node1 != null) {
51            cur.next = node1;
52        } else {
53            cur.next = node2;
54
55        }
56        return dummy.next;
57    }
58}
59/**
60
61
622. merge two lists
63
64
65
66 */