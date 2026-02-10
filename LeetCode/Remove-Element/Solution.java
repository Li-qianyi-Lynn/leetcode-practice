1class Solution {
2    public int removeElement(int[] nums, int val) {
3        if (nums.length == 0) {
4            return 0;
5        }
6        int r = nums.length-1;
7        int l = 0;
8        while (l <= r) {
9            if (nums[l] == val) {
10                nums[l] = nums[r];
11                r--;
12
13            } else {
14                l++;
15            }
16        }
17        return l;
18        
19    }
20}