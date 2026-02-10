1class Solution {
2
3
4    public void rotate(int[] nums, int k) {
5        int[] copy = nums.clone();
6        int len = nums.length;
7        
8        if (len == 1 || len == k) {
9            return;
10        }
11
12        if (len > k) {
13            changeInt(k, nums, copy);
14            
15
16        } else if (len < k) {
17            int times = k % len; 
18            changeInt(times, nums, copy);
19
20
21        }
22        
23        
24    }
25
26    private void changeInt(int times, int[] nums, int[] copy) {
27        for (int i = 0; i < nums.length; i++) {
28                if ( i < times) {
29                    nums[i] = copy[i+ nums.length - times];
30
31                } else {
32                    nums[i] = copy[i - times];
33
34                }   
35
36            }
37
38    }
39}