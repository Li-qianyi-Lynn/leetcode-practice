class Solution {
    public ListNode swapPairs(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        stack.push(null);
        ListNode current = head;
        while(current != null)
        {
            if(stack.size() == 2)
            {
                ListNode next = current.next;
                ListNode prior = stack.pop();
                ListNode priorPrior = stack.pop();
                if(priorPrior != null) priorPrior.next = current;
                else head = current;
                current.next = prior;
                prior.next = next;
                current = prior;                
            }
            stack.push(current);
            current = current.next;
        }
        return head;
    }
}