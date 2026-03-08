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
12    public ListNode reverseBetween(ListNode head, int left, int right) {
13        ListNode dummy = new ListNode(0);
14        dummy.next = head;
15        ListNode pre = dummy;
16
17
18        // check pre
19        for (int i = 0; i < left-1; i++) {
20            pre = pre.next;
21        }
22        //reverse
23        ListNode end = pre.next;
24        for (int i = 0; i < right - left;i++) {
25            
26            ListNode next = end.next;
27            end.next = next.next;
28            next.next = pre.next;
29            pre.next = next;
30
31        }
32        return dummy.next;
33        
34    }
35}
36
37/**
38dumy[1,  2,  3, 4 , 5]
39     pre end next
40
41cur: reversed tail
42next -> pre.next
43
44
45
46 */