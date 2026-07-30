1class Solution {
2    public boolean validTree(int n, int[][] edges) {
3        // pruning
4        if (edges.length != n-1) {
5            return false;
6
7        }
8
9        List<List<Integer>> adj = new ArrayList<>();
10        // build adjacency list
11        for (int i = 0; i < n; i++) {
12            adj.add(new ArrayList<>());
13        }
14
15        for (int[] edge : edges) {
16            int u = edge[0];
17            int v = edge[1];
18            adj.get(u).add(v);
19            adj.get(v).add(u);
20        }
21
22        // check graph connectivity with bfs -> if visited nodes num == n
23        Deque<Integer> dq = new ArrayDeque<>();
24        List<Integer> visited = new ArrayList<>();
25        dq.offerLast(0);
26        visited.add(0);
27
28        while (!dq.isEmpty()) {
29            int cur = dq.pollFirst();
30            List<Integer> neis = adj.get(cur);
31            for (int nei : neis ) {
32                if (!visited.contains(nei)) {
33                    visited.add(nei);
34                    dq.offerLast(nei);
35
36                }
37
38            }
39
40        }
41        return visited.size() == n;
42
43
44
45        
46    }
47}