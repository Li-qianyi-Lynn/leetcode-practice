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
13    // 1. 递归基准条件：空链表或只有一个节点，天然有序
14        if (head == null || head.next == null) {
15            return head;
16
17        }
18
19        ListNode prev = null;
20        ListNode slow = head;
21        ListNode fast = head;   
22
23        while (fast != null && fast.next != null) {
24            prev = slow;
25            slow = slow.next;
26            fast = fast.next.next;
27
28        }
29
30        prev.next = null;
31
32        ListNode left = sortList(head);
33        ListNode right = sortList(slow);
34
35        return merge(left, right);
36    }
37
38    private ListNode merge(ListNode l1, ListNode l2) {
39        ListNode dummy = new ListNode (0);
40        ListNode cur = dummy;
41
42        while (l1 != null && l2 != null) {
43            if (l1.val < l2.val) {
44                cur.next = l1;
45                l1 = l1.next;
46
47            } else {
48                cur.next = l2;
49                l2 = l2.next;
50
51            }
52            cur = cur.next;
53        }
54
55        if (l1 != null ) {
56            cur.next = l1;
57        } 
58
59        if (l2 != null ) {
60            cur.next = l2;
61        }
62
63        return dummy.next;
64    }
65}
66
67/**
68space O(1)
69
70 */