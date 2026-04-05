1class Solution {
2    public double findMaxAverage(int[] nums, int k) {
3        if (nums.length == 1) {
4            return (double)nums[0];
5        }
6
7       // pre k sum
8       int kSum = 0;
9       for (int i = 0; i < k; i++) {
10            kSum += nums[i];
11       }
12
13       double res = kSum;
14       for (int i = k; i < nums.length; i++) {
15
16          kSum = kSum - nums[i-k] + nums[i];
17          res = Math.max(kSum, res);
18    
19       }
20       return res / k;
21        
22    }
23}