1class Solution {
2    public int rob(int[] nums) {
3        // edge case
4        if (nums.length == 1) {
5            return nums[0];
6
7        }
8        int n = nums.length;
9        int max1 = basic(nums, 0, n-2);
10        int max2 = basic(nums,1,n-1);
11        return Math.max(max1,max2);
12        
13    }
14
15    private int basic(int[] nums, int start, int end) {
16        int len = end - start + 1;
17        if (len == 1) return nums[start];
18        int[] dp = new int[len];
19        //init
20        dp[0] = nums[start];
21        dp[1] = Math.max(nums[start], nums[start + 1]);
22
23        
24        for (int i = 2; i < len; i++) {
25        
26            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
27
28            
29            
30        }
31        return dp[len-1];
32
33
34    }
35
36
37}
38/*
39house in a circle: rob first or rob last [0,n-2] [1,n-1]
40cannot robber adjacent houses
41
42input: int[]
43output: int max num
44
45rob i:
46dp[i] = dp[i-2] + nums[i]
47
48not rob i
49dp[i] = dp[i-1]
50
51dp[i] = Math.max((dp[i-2] + nums[i]),dp[i-1]);
52
53
54
55
56*/