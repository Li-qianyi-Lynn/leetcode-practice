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
12    public int pairSum(ListNode head) {
13        ListNode slow = head;
14        ListNode fast = head;
15        while (fast != null && fast.next != null) {
16            slow = slow.next;
17            fast = fast.next.next;
18        }
19        // slow : second half new head
20        ListNode newHead = reverse(slow); 
21        int res = 0;
22        while (newHead != null) {
23            int curSum = head.val + newHead.val;
24            res = Math.max(res,curSum);
25            head = head.next;
26            newHead = newHead.next;
27        }
28        return res;
29
30        
31    }
32    private ListNode reverse(ListNode head) {
33        ListNode pre = null;
34        ListNode cur = head;
35        while (cur != null) {
36            ListNode nex = cur.next;
37            cur.next = pre;
38            pre = cur;
39            cur = nex;
40        }
41        return pre;
42    }
43}
44/**
45
467 6 5  4 <- 10 <- 11
471. cut off
482. reverse 
493. calculate
50
51 */