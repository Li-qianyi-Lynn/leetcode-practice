# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        # 1. 用快慢指针找中点
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        # 2. 只反转后半部分（从 slow 开始）
        prev = None
        curr = slow
        while curr:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node
            
        # 3. 前半部分 (head) 和反转后的后半部分 (prev) 双指针同步遍历
        res = 0
        p1 = head
        p2 = prev
        while p2:  # 后半部分长度是 n/2，以 p2 为循环条件
            res = max(res, p1.val + p2.val)
            p1 = p1.next
            p2 = p2.next
            
        return res