1class Solution {
2    public int maxSubArray(int[] nums) {
3        
4
5        int maxSum = nums[0];
6        if (nums.length == 1) {
7            return maxSum;
8
9        }
10        int currentSum = nums[0];
11        
12        for (int i = 1; i < nums.length; i++) {
13            // 当前位置的最大子数组和
14            currentSum = Math.max(nums[i], currentSum + nums[i]);
15            // 更新全局最大值
16            maxSum = Math.max(maxSum, currentSum);
17        }
18        
19        return maxSum;
20
21
22        
23        
24    }
25}