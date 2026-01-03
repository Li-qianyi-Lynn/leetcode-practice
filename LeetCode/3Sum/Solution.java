1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        List<List<Integer>> results = new ArrayList<>();
4        /**
5        step1: sort, prepare for two pointers O(nlogn)
6        step2: iterate nums,use two pointers (l = i+1; r = length-1) to check 
7        if nums[i] + nums[l] +nums[r] == 0. O(n)
8            - it is possible to have duplicate res, we need to remove duplicates
9            - i == i+1 continue;
10            - l == l+1 continue;
11            - r == r -1 continue;
12
13
14        step3: add res to results;
15        
16     
17         */
18
19        Arrays.sort(nums);
20        int len = nums.length;
21
22        for (int i = 0; i < len; i++) {
23            if (nums[i] > 0) break;
24            if (i > 0 && nums[i] == nums[i-1]) continue;
25
26            int l = i +1;
27            int r = len -1;
28
29            while (l < r) {
30                if (nums[i] + nums[l] + nums[r] < 0) {
31                    l ++;
32
33                } else if (nums[i] + nums[l] + nums[r] > 0) {
34                    r --;
35
36                } else {
37                    results.add(Arrays.asList(nums[i], nums[r],nums[l]));
38                    l++;
39                    r--;
40
41                    while (l < r && nums[l] == nums[l - 1]) {
42                        l++;
43
44                    }
45                    while (l < r && nums[r] == nums[r + 1]) {
46                        r--;
47
48                    }
49
50                    // when i found one solution, skip duplicated l!!
51                }
52
53            }
54
55        }
56
57        return results;
58        
59    }
60}