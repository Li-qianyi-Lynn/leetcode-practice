1class Solution {
2    public int majorityElement(int[] nums) {
3        if (nums.length == 1) {
4            return nums[0];
5
6        }
7        int count = 1;
8        int res = nums[0];
9        for (int i = 1; i < nums.length; i++) {
10            if (count == 0) {
11                res = nums[i];
12                count = 1;
13            } else if (nums[i] == res) {
14                count++;
15
16            } else {
17                count --;
18            }
19
20            if (count > nums.length / 2) {
21                break;
22
23            }
24        }
25        return res;
26
27        
28    }
29}
30/**
31
32
33
34 */