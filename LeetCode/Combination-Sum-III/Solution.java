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
18            return;
19        }
20
21        if (size > k || curSum > n || num > 9 || num < 1) {
22            return;
23        }
24
25      
26        cur.add(num);
27        backtracking(k,n, curSum + num, cur ,num+1);
28        cur.remove(cur.size()-1);
29
30
31        backtracking(k,n, curSum, cur ,num+1);
32        
33
34
35
36    }
37}
38/**
39backtracking: 
40
411- 9 
42if curSum == n && size == k , add the list to the res List
43
44
45
46 */