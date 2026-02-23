1class Solution {
2    public int minSubArrayLen(int target, int[] nums) {
3        int r;
4        int l = 0;
5        int minLen = Integer.MAX_VALUE;
6        int curSum = 0;
7
8        for (r = 0; r < nums.length; r++) {
9            if (nums[r] == target) {
10                return 1;
11            }
12            curSum += nums[r];
13
14            while (curSum >= target) { // 一直收左边界
15                int curLen = r -l +1;
16                minLen = Math.min(curLen, minLen);
17                curSum -= nums[l];
18                l++;
19            }
20
21        }
22        return minLen == Integer.MAX_VALUE ? 0 : minLen;
23        
24    }
25}