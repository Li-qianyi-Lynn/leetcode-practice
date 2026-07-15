1class Solution {
2    private List<List<Integer>> res = new ArrayList<>();
3    public List<List<Integer>> combinationSum(int[] candidates, int target) {
4        Arrays.sort(candidates);
5        List<Integer> list = new ArrayList<>();
6        if (candidates.length == 0) {
7            return res;
8        }
9
10        backtracking(candidates, target, list, 0, 0);
11        return res;
12        
13    }
14
15    private void backtracking (int[] candidates, int target, List<Integer> list, int idx, int sum) {
16        //base case
17        if (target == sum) {
18            res.add(new ArrayList<>(list));
19            return;
20        }
21
22        if (sum > target) {
23            return;
24        }
25
26
27        //recursive rules
28        for (int i = idx; i < candidates.length; i++) {
29          
30            list.add(candidates[i]);
31            backtracking(candidates, target, list, i, sum + candidates[i]);
32            list.remove(list.size()-1);
33       
34
35        }
36
37
38    }
39}
40
41/**
42backtracking
43
44
45
46
47
48 */