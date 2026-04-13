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
12    public ListNode oddEvenList(ListNode head) {
13        if (head == null || head.next == null || head.next.next == null) {
14            return head;
15        }
16        ListNode odd = new ListNode (0); // ji
17        ListNode even = new ListNode (0); // ou
18        ListNode oddcur = odd;
19        ListNode evencur = even;
20        ListNode cur = head;
21        
22
23        while (cur != null && cur.next != null) {
24            ListNode fi = cur;
25            ListNode se = cur.next;
26            cur = cur.next.next;
27            fi.next = null;
28            se.next = null;
29            oddcur.next = fi;
30            evencur.next = se;
31            oddcur = oddcur.next;
32            evencur = evencur.next;
33        } 
34        if (cur != null) {
35            oddcur.next = cur;
36            oddcur = oddcur.next;
37        } 
38
39        oddcur.next = even.next; 
40        return odd.next;
41    }
42
43}