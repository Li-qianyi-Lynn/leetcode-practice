class Solution {
    public boolean validTree(int n, int[][] edges) {
        // pruning
        if (edges.length != n-1) {
            return false;

        }

        List<List<Integer>> adj = new ArrayList<>();
        // build adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // check graph connectivity with bfs -> if visited nodes num == n
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        dq.offerLast(0);
        visited[0] = true;;

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            List<Integer> neis = adj.get(cur);
            for (int nei : neis ) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    dq.offerLast(nei);

                }

            }

        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                return false;

            }

        }
        return true;



        
    }
}