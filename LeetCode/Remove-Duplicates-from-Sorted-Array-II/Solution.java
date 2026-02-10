1class Solution {
2    public int removeDuplicates(int[] nums) {
3        if (nums.length <= 2) {
4            return nums.length;
5        }
6        int valid = 1;
7        int times = 1;
8        for (int i = 1; i < nums.length; i++) {
9            if (nums[i] == nums[i-1]) {
10                times++;
11
12            } else {
13                times = 1;
14            }
15
16            if (times <= 2) {
17                nums[valid] = nums[i];
18                valid ++;
19            }
20        }
21        return valid;    
22    }
23}
24/**
25K: the num of nums[i] appeared one or two times
26
27valid
28for loop: 1- len-1
29times = 1
30nums[i]== nums[i-1]
31times++;
32
33else:
34times = 1
35
36if times <= 2
37nums[valid] = nums[i]
38
39return valid
40 */