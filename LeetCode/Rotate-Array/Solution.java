1class Solution {
2    public void rotate(int[] nums, int k) {
3        if (nums.length == 1 || k == 0) {
4            return;   
5        }
6
7        // get times
8        int len = nums.length;
9        int times = k % len;
10        if (times == 0) {
11            return;
12
13        }
14
15        int[] copy = new int[len];
16        for (int i = 0; i < len; i++) {
17            copy[i] = nums[i];
18
19        }
20
21        int start = len - times;
22        for (int i = 0; i < times; i++) {
23            nums[i] = copy[start];
24            start++;
25
26        }
27        int j = 0;
28        for (int i = times; i < len; i++) {
29            nums[i] = copy[j];
30            j++;
31
32        }
33        
34    }
35}