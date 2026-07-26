1class Solution {
2    public void rotate(int[] nums, int k) {
3        if (nums.length == 1) {
4            return;
5        }
6        int n = nums.length;
7        k = k % nums.length;
8        reverse(nums, 0, n-1);
9        reverse(nums,0, k-1);
10        reverse(nums, k, n-1);
11
12
13        
14    }
15
16    private void reverse(int[] nums, int start, int end) {
17        while (start < end ) {
18            int temp = nums[start];
19            nums[start] = nums[end];
20            nums[end] = temp;
21            start ++;
22            end --;
23        }
24        
25
26    }
27}
28/**
29reverse 3 times
30
31[1,2,3,4,5,6,7]
32
331. all
342. first 3
353. last 4
36
37
38 */