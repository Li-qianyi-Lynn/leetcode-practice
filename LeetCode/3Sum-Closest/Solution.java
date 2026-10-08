1class Solution {
2    public int threeSumClosest(int[] nums, int target) {
3        int res = nums[0] + nums[1] + nums[2];
4        Arrays.sort(nums);
5        int n = nums.length;
6        //pruning
7        if (n == 3) {
8            return res;
9        }
10
11        for (int i = 0; i < n-2; i++) {
12            int l = i+1;
13            int r = n-1; 
14
15            while (l < r) {
16                int curSum = nums[i] + nums[l] + nums[r];
17
18                if (curSum == target) {
19                    return curSum;
20                } else if (curSum < target) {
21                    l++;
22                } else {
23                    r--;
24                }
25                if (Math.abs(target - curSum) < Math.abs(target - res)) {
26
27                    res = curSum;
28                }
29            }
30        }
31        return res;
32
33        
34    }
35}