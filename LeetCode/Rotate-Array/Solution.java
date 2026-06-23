1class Solution {
2    public void rotate(int[] nums, int k) {
3        if (nums.length == 1 || k == 0) {
4            return;
5        }
6        int len = nums.length;
7        k = k % len;
8        if (k == 0) {
9            return;
10        }
11
12        reverse(nums, 0, len-1);
13        reverse(nums, 0, k-1);
14        reverse(nums, k, len-1);
15        
16    }
17
18    private void reverse(int[] nums, int start, int end) {
19        if (nums.length == 0) {
20            return;
21        }
22
23        int temp = 0;
24        while (start < end) {
25            temp = nums[start];
26            nums[start] = nums[end];
27            nums[end] = temp;
28            start++;
29            end--;
30        }
31
32
33    }
34}
35/**
36
37update k 
38
39reverse 3 times
40
417654321
42
43 */