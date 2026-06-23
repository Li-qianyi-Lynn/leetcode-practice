1class Solution {
2    public int majorityElement(int[] nums) {
3        if (nums.length == 1) {
4            return nums[0];
5
6        }
7        int res = nums[0];
8        int times = 1;
9        for (int i = 1; i < nums.length; i++) {
10            if (times == 0) {
11                res = nums[i];
12                times = 1;
13                continue;
14
15            } 
16            if (nums[i] == res) {
17                times++;
18
19            } else {
20                times--;
21            }
22
23        }
24        return res;
25        
26    }
27}