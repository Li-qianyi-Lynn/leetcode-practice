1class Solution {
2    public int lengthOfLIS(int[] nums) {
3        int[] dp = new int[nums.length];
4        Arrays.fill(dp, 1);
5        int res = Integer.MIN_VALUE;
6    
7        for (int i = 1; i < nums.length; i++) { // 第一个肯定就是1 了,skip
8            for (int j = 0; j < i; j++) {
9                if (nums[j] < nums[i]) {
10                    dp[i] = Math.max(dp[i],dp[j]+1);
11                }
12            }
13        }
14
15        for (int num : dp) {
16            res = Math.max(num,res);
17
18        }
19        return res;
20        
21    }
22}
23
24/**
25
261. int[] dp: 记录以nums[i] 为终点的最长的increasing subsequence
27初始都是1
28
292. 遍历nums， 更新dp[]
30找i之前的nums[j]是否< nums[i]
31- yes: math.max(dp[i],dp[j]+1)
32- no continue
33for() {
34
35}
363. iterate dp[], find the max one
37
38
39 */