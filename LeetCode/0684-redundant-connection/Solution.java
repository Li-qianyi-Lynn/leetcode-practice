class Solution {
    // 定义并查集类
    class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        // 查找根节点（路径压缩）
        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        // 合并两个节点，如果已经连通则返回 false
        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                return true;
            }
            return false;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            // 如果 union 返回 false，说明 edge[0] 和 edge[1] 已经连通了
            // 此时再连这条边，就形成了环
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }
        
        return new int[0];
    }
}