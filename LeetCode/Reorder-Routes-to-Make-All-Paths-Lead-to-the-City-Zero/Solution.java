1class Solution {
2    public int minReorder(int n, int[][] connections) {
3        List<List<int[]>> adj = new ArrayList<>();
4        for (int i = 0; i < n; i++) {
5            adj.add(new ArrayList<>());
6
7        }
8        for (int[] edge : connections) {
9            adj.get(edge[0]).add(new int[]{edge[1],1});
10            adj.get(edge[1]).add(new int[]{edge[0],0});
11
12        }
13
14        boolean[] visited = new boolean[n];
15        return dfs(adj, visited, 0);
16        
17    }
18
19    private int dfs(List<List<int[]>> adj, boolean[] visited, int curr) {
20        visited[curr] = true;
21        int changeCount = 0;
22        
23        for (int[] neighbor : adj.get(curr)) {
24            int nextNode = neighbor[0];
25            int isOriginalDirection = neighbor[1];
26            
27            if (!visited[nextNode]) {
28                // 如果是从 curr 指向 nextNode 的原始边，说明方向错了（背离城市0）
29                // 因为我们是从城市 0 出发向外走的
30                changeCount += isOriginalDirection;
31                changeCount += dfs(adj, visited, nextNode);
32            }
33        }
34        
35        return changeCount;
36    }
37}