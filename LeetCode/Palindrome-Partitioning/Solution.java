1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    List<List<String>> res = new ArrayList<>();
6    List<String> path = new ArrayList<>();
7    boolean[][] isPal;
8
9    public List<List<String>> partition(String s) {
10        int n = s.length();
11        isPal = new boolean[n][n];
12
13        // 步骤 1：利用中心扩展法预处理所有的回文子串
14        for (int i = 0; i < n; i++) {
15            // 奇数长度中心扩散（中心是字符 s[i]）
16            expand(s, i, i);
17            // 偶数长度中心扩散（中心是 s[i] 和 s[i+1] 之间的空隙）
18            expand(s, i, i + 1);
19        }
20
21        // 步骤 2：标准回溯切割
22        backtrack(s, 0);
23        return res;
24    }
25
26    // 中心扩展辅助函数
27    private void expand(String s, int left, int right) {
28        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
29            isPal[left][right] = true;
30            left--;
31            right++;
32        }
33    }
34
35    private void backtrack(String s, int start) {
36        // 切割到字符串末尾，说明找到了一组完整的有效分割方案
37        if (start >= s.length()) {
38            res.add(new ArrayList<>(path));
39            return;
40        }
41
42        for (int i = start; i < s.length(); i++) {
43            // O(1) 直接读取预处理好的回文结果
44            if (isPal[start][i]) {
45                path.add(s.substring(start, i + 1));
46                backtrack(s, i + 1);
47                path.remove(path.size() - 1); // 回溯撤销选择
48            }
49        }
50    }
51}