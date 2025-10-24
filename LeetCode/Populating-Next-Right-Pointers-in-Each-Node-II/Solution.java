/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {return root;}
        Deque<Node> deque = new LinkedList<>();

        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Node pre = null;
            for (int i = 1; i <= size; i++) {
                Node cur = deque.pollFirst();
                if (cur.left != null) {deque.offerLast(cur.left);}
                if (cur.right != null) {deque.offerLast(cur.right);}

                if (pre != null) {pre.next = cur;}
                pre = cur;

            }

        }
        return root;

        
    }
}