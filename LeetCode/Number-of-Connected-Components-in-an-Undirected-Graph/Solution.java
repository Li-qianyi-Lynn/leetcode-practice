1class UnionFind {
2    int[] parents;
3    int counts;
4    UnionFind (int n) {
5        parents = new int[n];
6        counts = n;
7        for (int i = 0; i < n; i++) {
8            parents[i] = i;
9        }
10    }
11
12    public int find(int i) {
13        if (parents[i] == i) {
14            parents[i] = i;
15        } else {
16            parents[i] = find(parents[i]);
17        }
18        return parents[i];
19    }
20
21    public boolean union(int i, int j) {
22        int rootI = find(i);
23        int rootJ = find(j);
24
25        if (rootI == rootJ) {
26            return false;
27        }        
28        parents[rootI] = rootJ; // 连的是根！！！！！！
29        counts--;
30        return true;
31    }
32}
33
34class Solution {
35    public int countComponents(int n, int[][] edges) {
36        if (n == 1) {
37            return 1;
38        }
39
40        UnionFind uf = new UnionFind(n);
41        for (int[] edge : edges) {
42            uf.union(edge[0],edge[1]);
43        }
44   
45        return uf.counts;
46        
47    }
48}
49/**
50union find
51
52find node roots 
53
54union them 
55count how many roots?
56
57
58 */