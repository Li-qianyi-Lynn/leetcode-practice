1# Definition for singly-linked list.
2# class ListNode:
3#     def __init__(self, val=0, next=None):
4#         self.val = val
5#         self.next = next
6class Solution:
7    def swapPairs(self, head: ListNode | None) -> ListNode | None:
8        dummy = ListNode(0)
9        dummy.next = head
10        cur = dummy
11
12        while cur.next and cur.next.next:
13            node1 = cur.next
14            node2 = cur.next.next
15            node_next = cur.next.next.next
16
17            cur.next = node2
18            node2.next = node1
19            node1.next = node_next
20            cur = node1
21        
22        return dummy.next
23
24        