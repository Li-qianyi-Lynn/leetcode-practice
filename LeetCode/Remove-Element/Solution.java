1class Solution {
2    public int removeElement(int[] nums, int val) {
3        if (nums.length == 0) {
4            return 0;
5        }
6
7        int s = 0;
8        for (int f = 0; f < nums.length; f++) {
9            if (nums[f] != val) {
10                nums[s] = nums[f];
11                s++;
12            }
13        }
14        return s;
15        
16    }
17}
18/**
19
20nums 
21int val
22
23output: int  the number of elements in nums which are not equal to val
24high level idea: quick fast pointer
25
26[0,1,3,0,4,0,4,2]
27               f           
28           s
29
30 */