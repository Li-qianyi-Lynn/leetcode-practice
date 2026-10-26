/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>(); // the set of neighbors of a node in the graph
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors; 
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        // step1
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));

        // step2 bfs deque->queue
        Deque<Node> dq = new ArrayDeque<>();
        dq.offerLast(node);
        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();
            // process the neighbots
            List<Node> neibors = cur.neighbors;
            // for sanity check
            if (neibors.size() == 0) {
                continue;
            }
            for (Node nei : neibors) {
                if (!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val));
                    dq.offerLast(nei);
                }
                // update the neibours
                map.get(cur).neighbors.add(map.get(nei));
            }

        }
        return map.get(node);
        
    }
}
/**
1. map: to store old Node and new node(val),cant copy the neibour directly

2. deal with the neibors: dfs/bfs
dq-> cur node -> check if the nei (old node) in the map, if not that means we need to create one; otherwise we just link the node in the map with the cur node
old -> new
1,[2,4] -> 1,[2,4]
2,[1,3] -> 2,empty
4,[1,3]


[2,4]
use bfs to process 2 and 4 
add 2 to the dq, update the map



 */