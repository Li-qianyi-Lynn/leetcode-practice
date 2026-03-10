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
12    public ListNode reverseKGroup(ListNode head, int k) {
13        ListNode dummy = new ListNode(0);
14        dummy.next = head;
15        ListNode cur = dummy;
16        ListNode pre = dummy;
17
18        while (cur != null) {
19            for (int i = 0; i < k && cur != null; i++ ) {
20                cur = cur.next;
21            }
22            if (cur == null) {
23                break;
24            }
25            ListNode curHead = pre.next;
26            ListNode newFir = cur.next;
27            cur.next = null; // cut off
28            pre.next = reverse(curHead);
29
30            curHead.next = newFir;
31            pre = curHead;
32            cur = curHead;
33        }
34        return dummy.next;
35        
36    }
37    private ListNode reverse(ListNode head) {
38        
39        ListNode cur = head;
40        ListNode pre = null;
41
42        while (cur != null) {
43            ListNode next = cur.next;
44            cur.next = pre;
45            pre = cur;
46            cur = next;
47
48        }
49        return pre;
50    }
51}
52/**
53divided into diff parts len= k
54
55reverse the range
56reconnect
57
58 dmy [1,2,3,4,5]
59  pre 
60         newFir
61        cur
62
63
64 */