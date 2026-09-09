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
13        if (head == null || head.next == null) {
14            return head;
15
16        }
17
18        // calculate the len of list
19        int len = 0;
20        ListNode cur = head;
21        while (cur != null) {
22            len++;
23            cur = cur.next;
24
25        }
26
27        ListNode dummy = new ListNode(0);
28        dummy.next = head;
29
30        for (int step = 1; step < len; step = step * 2) {
31            ListNode prev = dummy;
32            cur = dummy.next;
33
34            while (cur != null) {
35          
36                ListNode l1 = cur;
37                ListNode l2 = split(l1, step);
38                cur = split(l2, step);
39                
40                prev.next = merge(l1, l2);
41                while (prev.next != null) {
42                    prev = prev.next;
43                }
44            }
45
46        }
47        return dummy.next;
48
49        
50    }
51
52    private ListNode split(ListNode head, int n) {
53        for (int i = 1; head != null && i < n; i++) {
54            head = head.next;
55        }
56        if (head == null) return null;
57        ListNode next = head.next;
58        head.next = null; // 切断连接
59        return next;
60    }
61
62    private ListNode merge(ListNode l1, ListNode l2) {
63        ListNode dummy = new ListNode(0);
64        ListNode cur = dummy;
65
66        while (l1 != null && l2 != null) {
67            if (l1.val > l2.val) {
68                cur.next = l2;
69                l2 = l2.next;
70
71            } else {
72                cur.next = l1;
73                l1 = l1.next;
74            }
75            cur = cur.next;
76
77        }
78
79        if (l1 != null) {
80            cur.next = l1;
81
82        }
83        if (l2 != null) {
84            cur.next = l2;
85
86        }
87
88        return dummy.next;
89    }
90}
91
92/**
93space O(1)
94
95 */