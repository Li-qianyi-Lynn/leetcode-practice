1class Solution {
2    
3
4    public List<List<Integer>> combine(int n, int k) {
5        List<List<Integer>> res = new ArrayList<>();
6        List<Integer> cur = new ArrayList<>();
7        backtracking(n,k,res,cur,1);
8        return res;
9        
10    }
11
12    private void backtracking(int n, int k, List<List<Integer>> res, List<Integer> cur, int start) {
13        // base case
14        if (cur.size() == k) {
15            res.add(new ArrayList<>(cur));
16            return;
17        }
18
19        for (int i = start; i <= n; i++) {
20        
21            
22            cur.add(i);
23            
24            backtracking(n,k,res,cur,i+1); // 后面的数一定比前面的数大
25            cur.remove(cur.size()-1);
26
27
28        }
29
30
31    }
32}
33/**
34rec:
351. base case: cur.size() == k return 
362. for (i in 1-n) {
37    cur.add(i);
38    rec()
39    cur.remove(cur.size()-1);
40
41
42}
43
44
45 */