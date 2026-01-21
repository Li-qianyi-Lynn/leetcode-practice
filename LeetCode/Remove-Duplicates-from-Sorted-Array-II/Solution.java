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
13                    nums[valid] = nums[i];
14                    valid++;
15
16                } 
17            
18            } else {
19                times = 1;
20                nums[valid] = nums[i];
21                valid++;
22            }
23        }
24        return valid;
25        
26    }
27}
28/**
29two pointers
30
31valid index
32i regular pointers
33
34nums[i] == nums[i-1], times++
35check times     
36
37
38 */