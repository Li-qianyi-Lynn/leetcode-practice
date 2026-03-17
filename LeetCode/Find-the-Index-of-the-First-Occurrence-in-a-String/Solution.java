1class Solution {
2    public int strStr(String haystack, String needle) {
3        int n = haystack.length();
4        int m = needle.length();
5        if (m == 0) return 0;
6
7        // 1. 构建 next 数组
8        int[] next = new int[m];
9        for (int i = 1, j = 0; i < m; i++) {
10            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
11                j = next[j - 1];
12            }
13            if (needle.charAt(i) == needle.charAt(j)) {
14                j++;
15            }
16            next[i] = j;
17        }
18
19        // 2. 匹配过程
20        for (int i = 0, j = 0; i < n; i++) {
21            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
22                j = next[j - 1];
23            }
24            if (haystack.charAt(i) == needle.charAt(j)) {
25                j++;
26            }
27            if (j == m) {
28                return i - m + 1; // 找到匹配，返回起始索引
29            }
30        }
31
32        return -1;
33    }
34}