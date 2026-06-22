1class Solution {
2    public int removeDuplicates(int[] nums) {
3        if (nums.length == 1) {
4            return 1;
5        }
6        int s = 0;
7        for (int f = 1; f < nums.length; f++) {
8            if (nums[f] != nums[s]) {
9                s++;
10                nums[s] = nums[f];
11
12            }
13        }
14        
15        return s+1;
16    }
17}
18/**
19slow and fast pointers
20
21[0,1,2,3,4,2,2,3,3,4]
22         s
23                   f
24
25same: fast move 
26not same : s+1, nums[s]= nums[f]
27
280,0
29  
30return s+1
31 */