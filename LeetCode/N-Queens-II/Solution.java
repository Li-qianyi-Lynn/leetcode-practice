1class Solution {
2    private int count = 0;
3
4    public int totalNQueens(int n) {
5        
6        HashSet<Integer> col = new HashSet<>();
7        HashSet<Integer> dia = new HashSet<>();   //row+col
8        HashSet<Integer> antDia = new HashSet<>(); //col-row
9
10        backtracking(n, 0, antDia, col, dia);
11        return count;
12        
13    }
14    private void backtracking(int n, int idx, HashSet<Integer> antDia, HashSet<Integer> col,HashSet<Integer> dia ) { //todo
15        //base case
16        if (idx == n) {
17            count+=1;
18            return;
19        }
20        
21        for (int i = 0; i < n; i++) {
22            if (col.contains(i) || dia.contains(idx+i) ||antDia.contains(i-idx)) {
23                continue;
24            }
25            antDia.add(i-idx);
26            dia.add(idx+i);
27            col.add(i);
28            backtracking(n, idx+1, antDia, col, dia);
29            antDia.remove(i-idx);
30            dia.remove(idx+i);
31            col.remove(i);
32        }
33    }
34}