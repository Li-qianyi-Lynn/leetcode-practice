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
21    private void reverse(int[] nums, int start, int end) {
22        int l = start;
23        int r = end;
24        while (l < r) {
25            int temp = nums[l];
26            nums[l] = nums[r];
27            nums[r] = temp;
28            l++;
29            r--;
30        }
31
32    }
33}
34
35
36/**
37[1,2,3,4,｜ 5,6,7]
38
39reverse: 7 6 5 4 3 2 1
40reverse first k 0 - k-1
41reverse after k k - n-1
42
43
44 */