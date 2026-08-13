1class Solution {
2    public List<List<Integer>> permute(int[] nums) {
3        List<List<Integer>> res = new ArrayList<>();
4        List<Integer> cur = new ArrayList<>();
5        // HashSet<Integer> visited = new HashSet<>();
6        boolean[] visited = new boolean[21];
7        backtracking(res, cur, nums, visited); //todo
8        return res;
9    }
10
11    private void backtracking(List<List<Integer>> res, List<Integer> cur, int[] nums, /*HashSet<Integer> visited*/ boolean[] visited) { //todo
12        //base case
13        if (cur.size() == nums.length) {
14            res.add(new ArrayList<>(cur));
15            return;
16        }
17
18        for (int i = 0; i < nums.length; i++) {
19            int idx = nums[i] + 10;
20            if (!visited[idx]) {
21            // if (!visited.contains(nums[i])) {
22                cur.add(nums[i]); // [1,]
23                visited[idx] = true;
24                // visited.add(nums[i]);
25                backtracking(res, cur, nums, visited);     
26                cur.remove(cur.size()-1);
27                // visited.remove(nums[i]);
28                visited[idx] = false;
29            }  
30        }
31
32    }
33}
34