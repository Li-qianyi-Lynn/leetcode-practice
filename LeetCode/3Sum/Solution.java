1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        List<List<Integer>> res = new ArrayList<>();
4        /**
5        step1: sort, prepare for two pointers O(nlogn)
6        step2: iterate nums,use two pointers (l = i+1; r = length-1) to check 
7        if nums[i] + nums[l] +nums[r] == 0. O(n)
8            - it is possible to have duplicate res, we need to remove duplicates
9            - i == i-1 continue;
10            - l == l-1 continue;
11            - r == r +1 continue;
12
13
14        step3: add res to results;
15
16        tc:O(n* n)
17        sc:O(1)
18        
19     
20         */
21
22        int len = nums.length;
23        Arrays.sort(nums);
24        for (int i = 0; i < nums.length; i++) {
25            if (nums[i] > 0) {
26                break;
27            }
28            if (i > 0 && nums[i] == nums[i-1]) {
29                continue;
30            }
31
32            int l = i+1;
33            int r = len-1;
34
35            while (l < r) {
36                if ( nums[i] + nums[l] + nums[r] < 0) {
37                    l++;
38                } else if (nums[i] + nums[l] + nums[r] > 0) {
39                    r--;
40                } else {
41                    
42                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
43                    l++;
44                    r--;
45                    while (l < r && nums[l] == nums[l-1]) {
46                        l++;
47                    }
48                    while (l < r && nums[r] == nums[r+1]) {
49                        r--;
50
51                    }
52
53                   
54                    
55                }
56
57            }
58        }
59        return res;
60
61        
62    }
63}