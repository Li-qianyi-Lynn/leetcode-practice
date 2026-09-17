1public class Solution {
2    public int countComponents(int n, int[][] edges) {
3        List<List<Integer>> adj = new ArrayList<>();
4        boolean[] visit = new boolean[n];
5        for (int i = 0; i < n; i++) {
6            adj.add(new ArrayList<>());
7        }
8        for (int[] edge : edges) {
9            adj.get(edge[0]).add(edge[1]);
10            adj.get(edge[1]).add(edge[0]);
11        }
12
13        int res = 0;
14        for (int node = 0; node < n; node++) {
15            if (!visit[node]) {
16                dfs(adj, visit, node);
17                res++;
18            }
19        }
20        return res;
21    }
22
23    private void dfs(List<List<Integer>> adj, boolean[] visit, int node) {
24        visit[node] = true;
25        for (int nei : adj.get(node)) {
26            if (!visit[nei]) {
27                dfs(adj, visit, nei);
28            }
29        }
30    }
31}