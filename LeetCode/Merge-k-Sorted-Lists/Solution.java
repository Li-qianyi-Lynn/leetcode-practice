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
13        // edge case
14        if (lists.length == 0) {
15            return null;
16        }
17        // init
18        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
19        ListNode dummy = new ListNode(-1);
20        ListNode tail = dummy;
21
22        // iterate lists, linkedlist[0], put linkedlist[0] into heap
23        for (ListNode list : lists) {
24            if (list != null) {
25                heap.add(list);
26            }
27        }
28        // while: heap not empty, put peak int res(dummyhead.next), poll.next if exist, put that into heap
29        while (!heap.isEmpty()) {
30            ListNode cur = heap.poll();
31            tail.next = cur;
32            tail = tail.next;
33
34            if (cur.next != null) {
35                heap.add(cur.next);
36            }
37        }
38
39        // return dummyhead.next
40        return dummy.next;
41
42        
43    }
44}
45
46/**
47
48pq minheap
49dummyhead
50tail
51
52
53
54 */