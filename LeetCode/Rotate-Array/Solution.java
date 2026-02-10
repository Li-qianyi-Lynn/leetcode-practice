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
22        int n = nums.length;
23        int l = start;
24
25        int r = end;
26        while (l < r) {
27            int temp = nums[l];
28            nums[l] = nums[r];
29            nums[r] = temp;
30            l++;
31            r--;
32        }
33
34    }
35}
36
37
38/**
39[1,2,3,4,｜ 5,6,7]
40
41reverse: 7 6 5 4 3 2 1
42reverse first k 0 - k-1
43reverse after k k - n-1
44
45
46 */