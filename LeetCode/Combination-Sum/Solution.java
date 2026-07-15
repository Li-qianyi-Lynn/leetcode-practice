1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        Arrays.sort(candidates);
4        List<List<Integer>> res = new ArrayList<>();
5        List<Integer> cur = new ArrayList<>();
6        int sum = 0; // cur sum
7        backtracking(candidates, target, sum, res, cur, 0); //todo
8        return res;
9        
10    }
11
12    private void backtracking(int[] candidates, int target, int sum, List<List<Integer>> res, List<Integer> cur, int index) { //start
13        // base case 
14        if (sum == target) { // we find one possible List<Integer>
15            res.add(new ArrayList<>(cur));
16            return;
17
18        }
19
20        // if (sum > target) { // not meet the requirement
21        //     return;
22
23        // }
24
25
26        for (int i = index; i < candidates.length; i++ ) {
27            if (sum > target) {
28                break;
29            }
30            cur.add(candidates[i]);
31            // sum += candidates[i];
32            backtracking(candidates, target, sum + candidates[i], res, cur, i);
33            // sum -= candidates[i];
34            cur.remove(cur.size()-1);
35
36        }
37
38    }
39}
40
41/**
42delete duplication 
43we can use one num multiple times
44
45[2, 3, 5]
46[2,3,9,6,5,4]
47
48get one int from the candidates
49[2, 2, 2, 2] the sum == target  one res
50[2, 3, 3 ] one res
51
52recursion (backtracking)
53add num - continue - remove
54
55base case:
561. the sum == target return  
572. iterate the candidates 
583. add num - continue - remove
59
60
61 */