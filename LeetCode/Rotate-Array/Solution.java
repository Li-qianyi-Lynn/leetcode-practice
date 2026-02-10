1class Solution {
2
3
4    public void rotate(int[] nums, int k) {
5        int len = nums.length;
6        k = k % len;  // 处理 k > len 的情况
7        
8        if (k == 0) return;  // 不需要旋转
9        
10        int[] copy = nums.clone();
11        for (int i = 0; i < len; i++) {
12            nums[(i + k) % len] = copy[i];
13        }
14    //     int[] copy = nums.clone();
15    //     int len = nums.length;
16        
17    //     if (len == 1 || len == k) {
18    //         return;
19    //     }
20
21    //     if (len > k) {
22    //         changeInt(k, nums, copy);
23            
24
25    //     } else if (len < k) {
26    //         int times = k % len; 
27    //         changeInt(times, nums, copy);
28
29
30    //     }
31        
32        
33    // }
34
35    // private void changeInt(int times, int[] nums, int[] copy) {
36    //     for (int i = 0; i < nums.length; i++) {
37    //             if ( i < times) {
38    //                 nums[i] = copy[i+ nums.length - times];
39
40    //             } else {
41    //                 nums[i] = copy[i - times];
42
43    //             }   
44
45    //         }
46
47    }
48}