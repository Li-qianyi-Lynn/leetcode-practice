1class Solution {
2    class UnionFind {
3
4        int[] parents;
5
6        UnionFind(int n) {
7            parents = new int[n+1];
8            for (int i = 1; i < n+1; i++) {
9                parents[i] = i;
10            }
11        }
12        
13        //
14        boolean union(int i, int j) {
15            int rootI=find(i);
16            int rootJ=find(j);
17
18            if (rootI == rootJ) {
19                return false;
20
21            } else {
22                parents[rootI]= rootJ;
23                return true;
24            }
25        }
26
27        int find(int i) { 
28            if (parents[i] != i) {
29                parents[i] = find(parents[i]); 
30
31            }
32            return parents[i];
33
34
35        }
36    }
37
38    public int[] findRedundantConnection(int[][] edges) {
39        int n = edges.length;
40        UnionFind uf = new UnionFind(n);
41       
42
43        for (int[] edge : edges) {
44            
45            boolean cur = uf.union(edge[0],edge[1]);
46            if (!cur) {
47                return edge;
48            }
49
50        }
51        return new int[0];
52
53    }
54}