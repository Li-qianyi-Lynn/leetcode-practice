class Solution {
    class UnionFind {

        int[] parents;

        UnionFind(int n) {
            parents = new int[n+1];
            for (int i = 1; i < n+1; i++) {
                parents[i] = i;
            }
        }
        
        //
        boolean union(int i, int j) {
            int rootI=find(i);
            int rootJ=find(j);

            if (rootI == rootJ) {
                return false;

            } else {
                parents[rootI]= rootJ;
                return true;
            }
        }

        int find(int i) { 
            if (parents[i] != i) {
                parents[i] = find(parents[i]); 

            }
            return parents[i];


        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
       

        for (int[] edge : edges) {
            
            boolean cur = uf.union(edge[0],edge[1]);
            if (!cur) {
                return edge;
            }

        }
        return new int[0];

    }
}