1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        List<List<Integer>> res = new ArrayList<>();
4        Arrays.sort(nums);
5        //[-4,-1,-1,0,1,2,]
6        for (int i = 0; i < nums.length;i++) {
7            if (nums[i]> 0) {
8                break;
9            }
10            if (i > 0 && nums[i] == nums[i-1]) {
11                continue;
12            }
13            
14            int l = i+1;
15            int r = nums.length-1;
16
17            while (l < r) {
18                if ( nums[i] + nums[l] + nums[r] < 0) {
19                    l++;
20                } else if (nums[i] + nums[l] + nums[r] > 0) {
21                    r--;
22                } else {
23                    
24                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
25                    l++;
26                    r--;
27                    while (l < r && nums[l] == nums[l-1]) {
28                        l++;
29                    }
30                    while (l < r && nums[r] == nums[r+1]) {
31                        r--;
32
33                    }
34   
35                }
36
37            }
38        }
39        return res; 
40
41    }
42}