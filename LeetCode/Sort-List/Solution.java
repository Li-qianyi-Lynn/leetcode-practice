class Solution {
    public ListNode sortList(ListNode head) {
        
        ListNode curr = head;
        Queue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val); 
        while (curr != null) {
            queue.add(curr);
            curr = curr.next;
        }
        
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            curr.next = null;
            prev.next = curr;
            prev = curr;
        }
        return dummy.next;
    }
}