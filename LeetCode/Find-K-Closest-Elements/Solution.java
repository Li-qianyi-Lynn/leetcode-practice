1class Solution {
2    public List<Integer> findClosestElements(int[] arr, int k, int x) {
3        int n = arr.length;
4        List<Integer> res = new ArrayList<>();
5
6
7        if (k == n) {
8            for (int a : arr) {
9                res.add(a);
10
11            }
12            return res;
13
14        }
15        // edge cases
16        if (arr[0] > x) {
17            for (int i = 0; i < k; i++) {
18                res.add(arr[i]);
19            }
20            return res;
21
22        }
23
24        if (arr[n-1] < x) {
25            for (int i = n-k; i < n; i++) {
26                res.add(arr[i]);
27
28            }
29            return res;
30
31        }
32
33        // 1. 寻找中心点
34        int left = 0;
35        int right = n - 1;
36        int idx = 0;
37        while (left <= right) {
38            int mid = left + (right - left) / 2;
39            if (arr[mid] >= x) {
40                idx = mid;
41                right = mid - 1;
42            } else {
43                left = mid + 1;
44            }
45        }
46
47        // 2. 初始化双指针
48        int l = idx - 1; // 如果距离相同 选a
49        int r = idx;
50
51        // 3. 中心扩散：选出 k 个元素
52        while (r - l - 1 < k) {
53            if (l < 0) {
54                r++;
55            } else if (r >= n) {
56                l--;
57            } else {
58                // 比较距离
59                if (x - arr[l] <= arr[r] - x) {
60                    l--;
61                } else {
62                    r++;
63                }
64            }
65        }
66
67  
68        for (int i = l + 1; i < r; i++) {
69            res.add(arr[i]);
70        }
71        return res;
72    }
73}
74
75/**
761) edge cases
772) two pointer 找到这个数
78如果能找到，把这个数+到res里，k--, 
79-如果是0 return res
80-如果》0 
81
82
83
84 */