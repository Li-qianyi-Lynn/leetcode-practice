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
12    public ListNode mergeKLists(ListNode[] lists) {
13        if (lists.length == 0) {
14            return null;
15
16        }
17        int n = lists.length;
18        int interval = 1;
19        while (interval < n) {
20        // 两两合并：第 i 个和第 i + interval 个合并
21            for (int i = 0; i + interval < n; i = i + interval * 2) {
22                lists[i] = merge(lists[i], lists[i + interval]);
23            }
24            // 合并完一轮后，跨度翻倍
25            interval *= 2;
26        }
27        return lists[0];
28    
29       
30    }
31
32    private ListNode merge(ListNode l1, ListNode l2) {
33        ListNode dummy = new ListNode(0);
34        ListNode cur = dummy;
35
36        while (l1 != null && l2 != null) {
37            if (l1.val > l2.val) {
38                cur.next = l2;
39                cur = cur.next;
40                l2 = l2.next;
41            } else {
42                cur.next = l1;
43                cur = cur.next;
44                l1 = l1.next;
45            }
46        }
47
48        if (l1 != null) {
49            cur.next = l1;
50
51        }
52        if (l2 != null) {
53            cur.next = l2;
54
55        }
56        return dummy.next;
57
58    }
59}
60
61/**
62iterate list，put all node into pq;
63build result
64
65
66 */