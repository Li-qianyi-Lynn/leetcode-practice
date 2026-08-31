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
12    public ListNode partition(ListNode head, int x) {
13        if (head == null) {
14            return null;
15        }
16
17        ListNode left = new ListNode(-101);
18        ListNode right = new ListNode(-101);
19        ListNode curL = left;
20        ListNode curR = right;
21        //[1,4,3,2,5,2],
22        //     cur
23        // left -> 1,2,2
24        //        curL 
25        // right-> 4,3,5
26        // curR
27        ListNode cur = head;
28
29        while (cur != null) {
30            if (cur.val < x) {
31                curL.next = cur;
32                curL = curL.next;
33                // curL.next = null; //todo
34            } else {
35                curR.next = cur;
36                curR = curR.next;
37                // curR.next = null; //todo
38
39            }
40            cur = cur.next;
41        }
42        curL.next = right.next;
43        curR.next=null;
44        return left.next;
45
46
47    }
48}