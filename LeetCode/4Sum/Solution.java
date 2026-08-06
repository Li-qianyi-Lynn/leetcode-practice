1class Solution {
2    public List<List<Integer>> fourSum(int[] nums, int target) {
3        List<List<Integer>> res = new ArrayList<>();
4
5        Arrays.sort(nums);
6
7        int n = nums.length;
8
9        for (int i = 0; i < n - 3; i++) {
10
11            // 去重
12            if (i > 0 && nums[i] == nums[i - 1]) {
13                continue;
14            }
15
16            for (int j = i + 1; j < n - 2; j++) {
17
18                // 去重
19                if (j > i + 1 && nums[j] == nums[j - 1]) {
20                    continue;
21                }
22
23                int left = j + 1;
24                int right = n - 1;
25
26                while (left < right) {
27
28                    long sum = (long) nums[i]
29                             + nums[j]
30                             + nums[left]
31                             + nums[right];
32
33                    if (sum == target) {
34
35                        res.add(Arrays.asList(
36                                nums[i],
37                                nums[j],
38                                nums[left],
39                                nums[right]));
40
41                        left++;
42                        right--;
43
44                        while (left < right &&
45                               nums[left] == nums[left - 1]) {
46                            left++;
47                        }
48
49                        while (left < right &&
50                               nums[right] == nums[right + 1]) {
51                            right--;
52                        }
53
54                    } else if (sum < target) {
55                        left++;
56                    } else {
57                        right--;
58                    }
59                }
60            }
61        }
62
63        return res;
64    }
65}