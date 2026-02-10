1class Solution {
2    public void rotate(int[] nums, int k) {
3        if (nums.length == 1 || k == 0) {
4            return;   
5        }
6
7        // get times
8        int len = nums.length;
9        k = k % len;
10        if (k == 0) {
11            return;
12
13        }
14        reverse(nums, 0, len-1);
15        reverse(nums, 0, k-1);
16        reverse(nums, k, len-1);
17
18
19    }
20
21    private void reverse(int[] nums, int l, int r) {
22        while (l < r) {
23            int temp = nums[l];
24            nums[l] = nums[r];
25            nums[r] = temp;
26            l++;
27            r--;
28        }
29
30    }
31}
32
33
34/**
35[1,2,3,4,｜ 5,6,7]
36
37reverse: 7 6 5 4 3 2 1
38reverse first k 0 - k-1
39reverse after k k - n-1
40
41
42 */