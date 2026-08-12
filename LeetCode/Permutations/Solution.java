1class Solution {
2    public List<List<Integer>> permute(int[] nums) {
3        List<List<Integer>> res = new ArrayList<>();
4        List<Integer> cur = new ArrayList<>();
5        HashSet<Integer> visited = new HashSet<>();
6        backtracking(res, cur, nums, visited); //todo
7        return res;
8
9        
10    }
11
12    private void backtracking(List<List<Integer>> res, List<Integer> cur, int[] nums, HashSet<Integer> visited) { //todo
13        //base case
14        if (cur.size() == nums.length) {
15            res.add(new ArrayList<>(cur));
16            return;
17        }
18
19        for (int i = 0; i < nums.length; i++) {
20            if (!visited.contains(nums[i])) {
21                cur.add(nums[i]); // [1,]
22                visited.add(nums[i]);
23                backtracking(res, cur, nums, visited);
24
25                
26                cur.remove(cur.size()-1);
27                visited.remove(nums[i]);
28            }  
29        }
30
31    }
32}