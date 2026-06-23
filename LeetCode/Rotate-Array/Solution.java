1class Solution {
2    
3    public void rotate(int[] nums, int k) {
4        if (nums.length == 1 || k == 0) {
5            return;
6        }
7        int[] res = new int[nums.length];
8        int len = nums.length;
9        k = k % len;
10        if (k == 0) {
11            return;
12        }
13
14        fill(res, nums, len-k, 0, k);
15        fill(res, nums, 0, k, len);
16        for (int i = 0; i < len; i++) {
17            nums[i] = res[i];
18
19        }
20
21        
22        
23    }
24
25    private void fill(int[] res, int[] nums, int start, int head, int tail) {
26        for (int i = head; i < tail; i++) {
27            res[i] = nums[start]; 
28            start++;
29        }
30
31    }
32
33    
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