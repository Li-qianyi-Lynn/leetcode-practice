1class Solution {
2    public boolean canJump(int[] nums) {
3        int n = nums.length;
4        int maxDis = 0;
5        for (int i = 0; i < n; i++ ) {
6            
7            if (i > maxDis) {
8                break;
9            }
10            int curStep = nums[i] + i;
11            maxDis = Math.max(maxDis, curStep);
12            if (maxDis >= n-1) {
13                return true;
14            }
15        }
16        return false;
17        
18    }
19}
20/**
21curStep = nums[i] + i >= n-1 true
22
23
24
25 */