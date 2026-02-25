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
18        ListNode pre = new ListNode();
19        ListNode slow = head;
20        ListNode fast = head;
21        while (fast != null && fast.next != null) {
22            pre = slow;
23            slow = slow.next;
24            fast = fast.next.next;
25
26        }
27        // head->...pre | slow -> null
28        pre.next = null;
29
30        ListNode l1 = sortList(head);
31        ListNode l2 = sortList(slow);
32
33        return merge(l1,l2);
34        
35    }
36
37    private ListNode merge(ListNode l1, ListNode l2) {
38        ListNode dummy = new ListNode(0);
39        ListNode cur = dummy;
40
41        while (l1 != null && l2 != null) {
42            if (l1.val > l2.val) {
43                cur.next = l2;
44                l2 = l2.next;
45
46            } else {
47                cur.next = l1;
48                l1 = l1.next;
49            }
50            cur = cur.next;
51
52        }
53
54        if (l1 != null) {
55            cur.next = l1;
56
57        }
58        if (l2 != null) {
59            cur.next = l2;
60
61        }
62
63        return dummy.next;
64    }
65}
66
67/**
68recursion sort
69找到终点分割
70断开next
71递归排序
72merge
73
74
75 */