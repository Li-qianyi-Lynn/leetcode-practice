1class Solution {
2    class UnionFind {
3        int[] parents;
4
5        public UnionFind(int n) {
6            parents = new int[n+1];
7            for (int i = 1; i < n+1; i++) {
8                parents[i] = i;
9
10            }
11
12        }
13
14        public int find(int i) {
15            if (parents[i] == i) {
16                return parents[i];
17
18            }
19
20            return find(parents[i]);
21
22        }
23
24        public boolean union(int i, int j) {
25            int rootI = find(i);
26            int rootJ = find(j);
27
28            if (rootI == rootJ) {
29                return false;
30            }
31
32            parents[rootI] = rootJ;
33            return true;
34
35        }
36
37    }
38    public int[] findRedundantConnection(int[][] edges) {
39        int n = edges.length;
40        UnionFind uf = new UnionFind(n);
41        for (int[] edge : edges) {
42            if (!uf.union(edge[0],edge[1])) {
43                return edge;
44
45
46            }
47
48        }
49        return new int[0];
50        
51    }
52}