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
16     
17         */
18
19        int len = nums.length;
20        Arrays.sort(nums);
21         
22        for (int i = 0; i < len; i++) {
23            if (nums[i] > 0) {
24                break; // stop for-loop (no possibilities to get the answer)
25            }
26            
27            if (i > 0 && nums[i] == nums[i-1]) { //duplicate i
28                continue; // next i
29            }
30            
31            int l = i+1;
32            int r = len-1;
33
34            while (l < r) {
35                if (nums[i] + nums[l] + nums[r] < 0) {
36                    l++;
37                } else if (nums[i] + nums[l] + nums[r] > 0) {
38                    r--;
39                } else {
40                    
41                    res.add(Arrays.asList(nums[i], nums[l], nums[r])); 
42                    l++;
43                    r--;
44                    
45                    while (l < r && nums[l] == nums[l-1]) {
46                        l++;
47                    }
48                    while (l < r && nums[r] == nums[r+1]) {
49                        r--;
50                    }
51                   
52                }
53
54            }
55        }
56        return res;   
57    }
58}