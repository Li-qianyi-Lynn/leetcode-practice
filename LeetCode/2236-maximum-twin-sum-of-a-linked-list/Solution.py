# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: ListNode | None) -> int:
        arr = []
        cur = head
        while cur:
            arr.append(cur.val)
            cur = cur.next
        
        res = 0
        n = len(arr)
        l,r = 0, n-1
        while l < r:
            cur_sum = arr[l] + arr[r]
            res = max(res,cur_sum)
            l+=1
            r-=1
        return res
        