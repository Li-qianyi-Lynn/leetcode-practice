1class Solution {
2    public int removeElement(int[] nums, int val) {
3        if (nums.length == 0) {
4            return 0;
5
6        }
7
8        int l = 0;
9        int r = nums.length-1;
10        while (l <= r) {
11            if (nums[l] == val) {
12                nums[l] = nums[r];
13                r--;
14            } else {
15                l++;
16            }
17
18        }
19        return l;
20        
21    }
22}
23
24/**
25two pointer
26
27l: if == val, swap
28
29
30
31 */