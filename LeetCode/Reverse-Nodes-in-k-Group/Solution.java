def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        n, curr = 0, head
        while curr:
            n += 1
            curr = curr.next
        
        dummy = nhead = ListNode() # the new list to insert to
        for _ in range(n//k):
            ntail = head  # the save the position for later jumping to
            for _ in range(k):
                head.next, nhead.next, head = nhead.next, head, head.next  # insert at nhead
            nhead = ntail  # move insertion point to the right by k steps
        ntail.next = head
        
        return dummy.next