1class Solution {
2    public List<Integer> findAnagrams(String s, String p) {
3        List<Integer> result = new ArrayList<>();
4        if (s.length() < p.length()) return result;
5
6        int[] pCount = new int[26];
7        int[] sCount = new int[26];
8
9        // 初始化：统计 p 的频率和 s 前 p.length() 个字符的频率
10        for (int i = 0; i < p.length(); i++) {
11            pCount[p.charAt(i) - 'a']++;
12            sCount[s.charAt(i) - 'a']++;
13        }
14
15        // 如果初始窗口就匹配
16        if (Arrays.equals(pCount, sCount)) result.add(0);
17
18        // 开始滑动窗口
19        for (int i = p.length(); i < s.length(); i++) {
20            // 右边进一个
21            sCount[s.charAt(i) - 'a']++;
22            // 左边出一个
23            sCount[s.charAt(i - p.length()) - 'a']--;
24
25            // 比较两个数组是否相等
26            if (Arrays.equals(pCount, sCount)) {
27                result.add(i - p.length() + 1);
28            }
29        }
30
31        return result;
32    }
33}