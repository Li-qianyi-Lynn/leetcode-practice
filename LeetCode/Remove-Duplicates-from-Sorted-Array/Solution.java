1class Solution {
2    public int removeDuplicates(int[] nums) {
3        if (nums.length == 1) {
4            return 1;
5
6        }
7
8        int valid = 1;
9        for (int i = 1; i < nums.length; i++) {
10            if (nums[i] != nums[i-1]) {
11                nums[valid] = nums[i];
12                valid++;
13            }
14        }
15        return valid;
16        
17    }
18}
19
20/**
21input: sorted nums[]
22output: number of unique elements in nums
23
24valid = 1
25
26[1,1,2]
27   |
28   i
29if nums[i] != nums[i-1]
30   nums[valid] = nums[i]
31   valid++
32
33return valid
34 */