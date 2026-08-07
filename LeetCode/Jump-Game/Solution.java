1class Solution {
2    public boolean canJump(int[] nums) {
3        // edge case
4        if (nums.length == 1) {
5            return true;
6
7        }
8        // [3,0,8,2,0,0,1]
9        //iterate nums
10        int n = nums.length;
11        int maxDistance = 0;
12        for (int i = 0; i < n; i++) {
13            if (maxDistance < i) {
14                return false;
15            }
16
17            maxDistance = Math.max(nums[i] + i,maxDistance);
18            if (maxDistance >= n-1) {
19                return true;
20
21            }
22         
23        }
24        return false;
25        
26    }
27}
28/**
29input: int[] nums nums[i]:  maximum jump length
30output: boolean
31
32
33iterate nums
34max: nums[i]+ i 
350? todo
36 */