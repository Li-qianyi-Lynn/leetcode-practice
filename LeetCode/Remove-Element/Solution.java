1class Solution {
2    public int removeElement(int[] nums, int val) {
3        if (nums.length == 0) {
4            return 0;
5        }
6
7        int l = 0; // count
8        int r = nums.length-1;
9
10        while (l <= r) {
11            if (nums[l] == val) {
12                nums[l] = nums[r];
13                r--;
14            } else {
15                l++;
16            }
17        }
18        return l;
19
20
21        
22    }
23}
24
25/**
26[5,4,3] 5
27return k
28not equal.   equal
29valid.      invalid
30l            r
31
32
33 */