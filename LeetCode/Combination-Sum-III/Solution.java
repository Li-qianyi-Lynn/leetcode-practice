1class Solution {
2    List<List<Integer>> res = new ArrayList<>();
3    public List<List<Integer>> combinationSum3(int k, int n) {
4        
5        backtracking(k,n,0,new ArrayList<>(),1);
6        return res;
7        
8    }
9
10    private void backtracking(int k, int n, int curSum, List<Integer> cur, int num) {
11        // base case
12        int size = cur.size();
13        if (size == k && curSum == n) {
14            res.add(new ArrayList<>(cur));
15            return;
16        }
17
18        if (size > k || curSum > n ) {
19            return;
20        }
21        for (int i = num; i <= 9; i++) {
22            cur.add(i);
23            backtracking(k,n, curSum + i, cur ,i+1);
24            cur.remove(cur.size()-1);
25
26        }        
27
28
29
30    }
31}
32/**
33backtracking: 
34
351- 9 
36if curSum == n && size == k , add the list to the res List
37
38
39
40 */