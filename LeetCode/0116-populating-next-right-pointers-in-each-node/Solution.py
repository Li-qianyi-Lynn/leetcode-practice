"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

    deque
    [2,3]
    prev = null
    prev cur.next-> next
  dq[i].next -> dq[i+1]
  prev 1          while cur        
p  2(cur).    3.  p.next = cur p = cur cur = cur.next
4.  5. 6. 7
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        
        if not root:
            return root
        if not root.left and not root.right:
            return root

        mostleft = root
        while mostleft.left: 
            cur = mostleft
            while cur :
                cur.left.next = cur.right
                if cur.next:
                    cur.right.next = cur.next.left
                
                cur = cur.next
            
            mostleft = mostleft.left
        
        return root


                



        