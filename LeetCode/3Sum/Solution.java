1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        Arrays.sort(nums);
4        List<List<Integer>> res = new ArrayList<>();
5        int n = nums.length;
6
7        for (int i = 0; i < n-2; i ++) {
8            if (i > 0 && nums[i] == nums[i-1]) {
9                continue;
10            }
11            if (nums[i] > 0) {
12                break;
13
14            }
15
16            int l = i+1;
17            int r = n-1;
18            while (l < r) {
19                List<Integer> cur = new ArrayList<>();
20                int curSum = nums[i] + nums[l] + nums[r];
21                if (curSum == 0) {
22                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
23                    l++;
24                    r--;
25                    while (l < r && nums[l] == nums[l-1]) {
26                        l++;
27                    }
28
29                    while (l < r && nums[r] == nums[r+1]) {
30                        r--;
31                    }
32
33
34                } else if (curSum < 0) {
35                    l++;
36
37                } else {
38                    r--;
39                }
40
41            }
42
43        }
44        return res;
45
46        
47    }
48}
49/**
50arrays.sort
51dedup
52
53for loop
54 l, r
55 int curSum = nums[i] + nums[l] + nums[r]
56
57curSum == 0; add to res
58curSum < 0; l++;
59curSum > 0; r--
60
61 */