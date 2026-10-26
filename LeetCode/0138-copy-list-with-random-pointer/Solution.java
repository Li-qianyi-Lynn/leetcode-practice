/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node copyNode = map.get(cur);
            copyNode.random = map.get(cur.random);
            copyNode.next = map.get(cur.next);
            cur = cur.next;
        }

        return map.get(head);
       
        
    }
}
/**
hashmap node -> copy node (val)
node.random = map.get(node.random)
node.next = map.get(node.next)




 */