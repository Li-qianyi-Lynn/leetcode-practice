1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        List<List<Integer>> res = new ArrayList<>();
4        List<Integer> cur = new ArrayList<>();
5
6        int sum = 0;
7        backtracking(candidates, target, 0, res, cur, 0);
8        return res;
9
10        
11    }
12
13    private void backtracking(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> cur, int sum) {
14       
15
16        
17        //base case
18        if (sum == target) {
19            res.add(new ArrayList<>(cur));
20            return;
21
22        } 
23        
24        if (sum > target) {
25            return;
26
27        } 
28        for (int i = index; i < candidates.length; i++) {
29            cur.add(candidates[i]);
30            sum += candidates[i];// 如果sum 加了， 后面要减
31            backtracking(candidates, target, i, res, cur, sum);
32            sum -= candidates[i];
33            cur.remove(cur.size()-1);
34
35        }
36    
37
38        
39    }
40
41    
42
43
44}
45
46/**
47curRes ArrayList 
48int sum = 0
49iterate candidates, get[i]
50sum += candidates[i]
51curRes.add(candidates[i])
52
53base case:
54if sum == target 
55    res.add(curRes)
56    return 
57
58if sum > target
59    remove(len-1)
60
61
62if sum < target
63    backtracking(.. i+1)
64    remove(len-1)
65    backtracking (i)
66    remove(len-1)
67
68
69 */