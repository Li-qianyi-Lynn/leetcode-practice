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
12    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
13        ListNode dummy = new ListNode(-1);
14        ListNode tail = dummy;
15        ListNode cur1 = list1;
16        ListNode cur2 = list2;
17
18        while (cur1 != null && cur2 != null) {
19            if (cur1.val < cur2.val) {
20                tail.next = cur1;
21                cur1 = cur1.next;
22            } else {
23                tail.next = cur2;
24                cur2 = cur2.next;
25            }
26            tail = tail.next;
27        }
28
29        while (cur1 != null) {
30            tail.next = cur1;
31            cur1 = cur1.next;
32            tail = tail.next;
33
34        }
35
36        while (cur2 != null) {
37            tail.next = cur2;
38            cur2 = cur2.next;
39            tail = tail.next;
40
41        }
42        tail.next = null;
43        return dummy.next;
44
45        
46    }
47}