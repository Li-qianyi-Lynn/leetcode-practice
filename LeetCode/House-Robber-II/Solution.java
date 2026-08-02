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
17        int[] dp = new int[len+1];
18        //init
19        dp[0] = 0;
20        dp[1] = nums[start];
21
22        
23        for (int i = 2; i <= len; i++) {
24        
25            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i-1]);
26
27            
28            
29        }
30        return dp[len];
31
32
33    }
34
35
36}
37/*
38house in a circle: rob first or rob last [0,n-2] [1,n-1]
39cannot robber adjacent houses
40
41input: int[]
42output: int max num
43
44rob i:
45dp[i] = dp[i-2] + nums[i]
46
47not rob i
48dp[i] = dp[i-1]
49
50dp[i] = Math.max((dp[i-2] + nums[i]),dp[i-1]);
51
52dp[0]：第 1 个房子的最大收益。
53dp[1]：前 2 个房子的最大收益。
54
55dp[len - 1]：前 len 个房子的最大收益（即最终答案）。
56
57
58
59
60*/