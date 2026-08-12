1class Solution {
2    public int maxSubarrayLength(int[] nums, int k) {
3        if (nums.length == 1) {
4            return 1;
5
6        }
7
8        Map<Integer, Integer> map = new HashMap<>();
9        int l = 0;
10        int r;
11        int n = nums.length;
12        int res = 0;
13        for (r = 0; r < n; r++) {
14            map.put(nums[r], map.getOrDefault(nums[r],0)+1);
15          
16
17            while (map.get(nums[r]) > k) {
18                map.put(nums[l],map.get(nums[l])-1);
19                l++;
20            }
21            res = Math.max(res, r-l+1);
22
23        }
24        return res;
25
26
27        
28    }
29}
30/**
31
32
33map: nums[i] -> freq 
34
35
36[1,2,3,1,2,3,1,2]
37|
38           |
39
40l, r
41for loop
421. get the nums[i], freq ++
43valid: get the length -> possible ans
44invalid: move l, update freq
45 */