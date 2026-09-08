1class Solution {
2    class UnionFind {
3        private int[] parents;
4
5        public UnionFind(int n) {
6            parents = new int[n+1];
7            for (int i = 1; i < n+1; i++) {
8                parents[i] = i;
9            }
10            
11        }
12
13        public int find(int i) {
14            if (i == parents[i]) {
15                return i;
16
17            }
18            return parents[i] = find(parents[i]);
19        }
20
21        public boolean union(int i, int j) {
22            int rootI = find(i);
23            int rootJ = find(j);
24
25            if (rootI != rootJ) {
26                parents[rootI]= rootJ;
27                return true;
28
29            }
30            return false;
31        }
32
33
34
35
36    }
37    public int[] findRedundantConnection(int[][] edges) {
38        int n = edges.length;
39        
40        UnionFind uf = new UnionFind(n);
41
42        for (int[] edge : edges) {
43            boolean res = uf.union(edge[0], edge[1]);
44            if (res != true) {
45                return edge;
46            }
47        }
48        return new int[0];
49    }
50}