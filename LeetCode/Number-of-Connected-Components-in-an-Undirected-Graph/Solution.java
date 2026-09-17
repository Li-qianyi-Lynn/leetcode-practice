1class Solution {
2    class UnionFind {
3        private int[] parent;
4        private int[] rank;
5        private int count;
6
7        public UnionFind(int n) {
8            this.count = n;
9            this.parent = new int[n];
10            this.rank = new int[n];
11            for (int i = 0; i < n; i++) {
12                parent[i] = i;
13                rank[i] = 1;
14            }
15        }
16
17        public int find(int i) {
18            if (parent[i] != i) {
19                parent[i] = find(parent[i]); // 路径压缩
20            }
21            return parent[i];
22        }
23
24        public boolean union(int x, int y) {
25            int rootX = find(x);
26            int rootY = find(y);
27
28            if (rootX != rootY) {
29                if (rank[rootX] < rank[rootY]) {
30                    parent[rootX] = rootY;
31                } else if (rank[rootX] > rank[rootY]) {
32                    parent[rootY] = rootX;
33                } else {
34                    parent[rootY] = rootX;
35                    rank[rootX]++;
36                }
37                count--; // 连通分量数 -1
38                return true;
39            }
40            return false;
41        }
42
43        public int getCount() {
44            return count;
45        }
46    }
47
48    public int countComponents(int n, int[][] edges) {
49        UnionFind uf = new UnionFind(n);
50        for (int[] edge : edges) {
51            uf.union(edge[0], edge[1]);
52        }
53        return uf.getCount();
54    }
55}