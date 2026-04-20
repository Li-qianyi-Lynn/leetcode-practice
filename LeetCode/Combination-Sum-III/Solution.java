1class Solution {
2    List<List<Integer>> res = new ArrayList<>();
3    public List<List<Integer>> combinationSum3(int k, int n) {
4        if (n ==1) {
5            return new ArrayList<>();
6
7        }
8        backtracking(k,n,0,new ArrayList<>(),1);
9        return res;
10        
11    }
12
13    private void backtracking(int k, int n, int curSum, List<Integer> cur, int num) {
14        // base case
15        int size = cur.size();
16        if (size == k && curSum == n) {
17            res.add(new ArrayList<>(cur));
18        }
19
20        if (size > k || curSum > n || num > 9 || num < 1) {
21            return;
22        }
23
24        for (int i = num; num <= 9; num++) {
25            cur.add(num);
26            backtracking(k,n, curSum + num, cur ,num+1);
27            cur.remove(cur.size()-1);
28
29
30
31        }
32      
33
34
35    }
36}
37/**
38backtracking: 
39
401- 9 
41if curSum == n && size == k , add the list to the res List
42
43
44
45 */