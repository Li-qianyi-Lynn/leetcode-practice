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
13        // step1:cut off the linkedlist in 2 parts -> slow and fast pointer
14        ListNode slow = head;
15        ListNode fast = head;
16        int res = 0;
17        while (fast != null && fast.next != null) {
18            slow = slow.next;
19            fast = fast.next.next;
20        }
21        // slow will be a new head of the second part 
22        // step2: reverse the second part 
23        ListNode newHead = reverse(slow);
24        // step3: iterate the two list at the same time -> update the res
25        // 5->4 1->2
26        while (newHead != null) {
27            int curSum = head.val + newHead.val;
28            res = Math.max(curSum, res);
29            head = head.next;
30            newHead = newHead.next;
31        }
32        return res;
33
34        
35    }
36
37    private ListNode reverse(ListNode node) {
38        ListNode pre = null;
39        ListNode cur = node;
40        while (cur != null) {
41            ListNode nex = cur.next;
42            cur.next = pre;
43            pre = cur;
44            cur = nex;
45        }
46        return pre; // the new head
47
48    }
49}
50/**
51input: head of a linkedlist
52output: maximum twin sum of the linked list.
53
541. cut off the linkedlist in 2 parts -> slow and fast pointer
552. reverse the second part 
563. iterate the two list at the same time -> update the res
57
58 */