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
13        if (head == null || k == 1) {
14            return head;
15
16        }
17
18        ListNode dummy = new ListNode(0);
19        dummy.next = head;
20        
21        // prev 始终指向每一组待翻转节点的前驱
22        ListNode prev = dummy;
23        ListNode end = dummy;
24        
25        while (end.next != null) {
26            // 1. 找到当前组的末尾
27            for (int i = 0; i < k && end != null; i++) end = end.next;
28            if (end == null) break; // 不足 k 个，跳出循环
29            
30            // 2. 记录当前组的起始和下一组的开头
31            ListNode start = prev.next;
32            ListNode next = end.next;
33            
34            // 3. 断开连接并翻转该小组
35            end.next = null;
36            prev.next = reverse(start);
37            
38            // 4. 将翻转后的尾部与后面接上
39            start.next = next;
40            
41            // 5. 移动指针，准备处理下一组
42            prev = start;
43            end = prev;
44        }
45        
46        return dummy.next;
47        
48    }
49
50    private ListNode reverse(ListNode head) {
51        ListNode pre = null;
52        ListNode cur = head;
53        while (cur != null) {
54            ListNode next = cur.next;
55            cur.next = pre;
56            pre = cur;
57            cur = next;
58        }
59        return pre;
60    }
61}
62/**
63null <-1 -> 2 -> 3 
64               next
65       pre. cur.
661 -> null 
67cur.next -> pre 
68pre = cur;
69cur = next;
70
71 */
72
73