1class Solution {
2    public int removeDuplicates(int[] nums) {
3        if (nums.length <= 2) {
4            return nums.length;    
5
6        }
7        int fast;
8        int slow = 1;
9        int times = 1;
10        for (fast = 1; fast < nums.length; fast++) {
11            
12            if (nums[fast] == nums[fast-1]) {
13                if (times < 2) {
14                    times++;
15
16                } else {
17                    continue;
18                }
19            } else {
20                times = 1;
21            }
22            nums[slow] = nums[fast];
23            slow++;
24
25        }
26        return slow;
27        
28        
29    }
30}
31
32/**
33two pointers
34fast: iterate nums, calculate nums[i] appeared how many times
35if times >= 2
36nums[slow] = nums[fast+1]; times = 1; slow++
37
38
39
40
41 */