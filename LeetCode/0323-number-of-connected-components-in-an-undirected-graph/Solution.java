class UnionFind {
    int[] parents;
    int counts;
    UnionFind (int n) {
        parents = new int[n];
        counts = n;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int find(int i) {
        if (parents[i] == i) {
            parents[i] = i;
        } else {
            parents[i] = find(parents[i]);
        }
 
        return parents[i];

    }

    public boolean union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
   

        if (rootI == rootJ) {
            return false;

        } 
            
        parents[rootI] = rootJ;
        counts--;
        return true;
        

    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n == 1) {
            return 1;

        }
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0],edge[1]);
        }

        
        return uf.counts;
        
    }
}
/**
union find

find node roots 

union them 
count how many roots?


 */