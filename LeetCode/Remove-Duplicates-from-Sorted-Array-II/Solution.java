1class Solution {
2    public int removeDuplicates(int[] nums) {
3        if (nums.length == 1) {
4            return 1;
5
6        }
7        int valid = 1;
8        int times = 1;
9        for (int i = 1; i < nums.length; i++) {
10            if (nums[i] == nums[i-1]) {
11                if (times <= 1) {
12                    times ++;
13                    // nums[valid] = nums[i];
14                    // valid++;
15
16                } else {
17                    continue;
18                }
19            
20            } else {
21                times = 1;
22               
23            }
24
25            nums[valid] = nums[i];
26            valid++;
27        }
28        return valid;
29        
30    }
31}
32/**
33two pointers
34
35valid index
36i regular pointers
37
38nums[i] == nums[i-1], times++
39check times     
40
41
42 */