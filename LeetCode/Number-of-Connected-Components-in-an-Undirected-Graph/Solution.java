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
18 
19        return parents[i];
20
21    }
22
23    public boolean union(int i, int j) {
24        int rootI = find(i);
25        int rootJ = find(j);
26   
27
28        if (rootI == rootJ) {
29            return false;
30
31        } 
32            
33        parents[rootI] = rootJ;
34        counts--;
35        return true;
36        
37
38    }
39}
40
41class Solution {
42    public int countComponents(int n, int[][] edges) {
43        if (n == 1) {
44            return 1;
45
46        }
47        UnionFind uf = new UnionFind(n);
48        for (int[] edge : edges) {
49            uf.union(edge[0],edge[1]);
50        }
51
52        
53        return uf.counts;
54        
55    }
56}
57/**
58union find
59
60find node roots 
61
62union them 
63count how many roots?
64
65
66 */