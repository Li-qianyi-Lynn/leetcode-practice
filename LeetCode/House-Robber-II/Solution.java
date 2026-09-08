1class Solution {
2    public int rob(int[] nums) {
3        
4        if (nums.length <= 1) {
5            return nums[0];
6
7        }
8        int n = nums.length-1;
9        int p1 =  robHelper(nums, 0, n-1);
10        int p2 =  robHelper(nums, 1, n);
11        return Math.max(p1,p2);
12
13
14    }
15    private int robHelper(int[] nums, int start, int end) {
16        int[] dp = new int[nums.length];
17        if (start == end) {
18            return nums[start];
19        }
20        
21        dp[start] = nums[start];
22        dp[start+1] = Math.max(nums[start], nums[start+1]);
23        for (int i = start+2; i <= end; i++) {
24            dp[i] = Math.max(dp[i-1], dp[i-2]+ nums[i]);
25
26        }
27        return dp[end];
28        
29    }
30}
31/**
32
331- n
340- n-1
35
36
37 */