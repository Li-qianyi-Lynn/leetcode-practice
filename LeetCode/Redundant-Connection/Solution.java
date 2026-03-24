1class Solution {
2    // 定义并查集类
3    class UnionFind {
4        private int[] parent;
5
6        public UnionFind(int n) {
7            parent = new int[n + 1];
8            for (int i = 1; i <= n; i++) {
9                parent[i] = i;
10            }
11        }
12
13        // 查找根节点（路径压缩）
14        public int find(int i) {
15            if (parent[i] == i) {
16                return i;
17            }
18            return parent[i] = find(parent[i]);
19        }
20
21        // 合并两个节点，如果已经连通则返回 false
22        public boolean union(int i, int j) {
23            int rootI = find(i);
24            int rootJ = find(j);
25            if (rootI != rootJ) {
26                parent[rootI] = rootJ;
27                return true;
28            }
29            return false;
30        }
31    }
32
33    public int[] findRedundantConnection(int[][] edges) {
34        int n = edges.length;
35        UnionFind uf = new UnionFind(n);
36
37        for (int[] edge : edges) {
38            // 如果 union 返回 false，说明 edge[0] 和 edge[1] 已经连通了
39            // 此时再连这条边，就形成了环
40            if (!uf.union(edge[0], edge[1])) {
41                return edge;
42            }
43        }
44        
45        return new int[0];
46    }
47}