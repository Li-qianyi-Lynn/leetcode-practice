1class Solution {
2    public int rob(int[] nums) {
3        
4        if (nums.length <= 1) {
5            return nums[0];
6
7        }
8        int n = nums.length-1;
9        int p1 =  robHelper(nums, 0, n-1);
10        int p2 =  robHelper(nums, 1, n);
11        return Math.max(p1,p2);
12
13
14    }
15    private int robHelper(int[] nums, int start, int end) {
16        if (start == end) {
17            return nums[start];
18
19        }
20        int first = nums[start];
21        int second = Math.max(nums[start+1], nums[start]);
22        for (int i = start+2; i <= end; i++) {
23            int temp = Math.max(second, first + nums[i]);
24            first = second;
25            second = temp;
26
27        }
28        return second;
29        
30    }
31}
32/**
33
341- n
350- n-1
36
37
38 */