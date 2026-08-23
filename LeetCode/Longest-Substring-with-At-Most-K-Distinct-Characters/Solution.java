1import java.util.HashMap;
2import java.util.Map;
3
4class Solution {
5    public int lengthOfLongestSubstringKDistinct(String s, int k) {
6        if (s == null || s.length() == 0 || k == 0) {
7            return 0;
8        }
9
10        Map<Character, Integer> countMap = new HashMap<>();
11        int left = 0;
12        int maxLen = 0;
13
14        for (int right = 0; right < s.length(); right++) {
15            char rChar = s.charAt(right);
16            countMap.put(rChar, countMap.getOrDefault(rChar, 0) + 1);
17
18            // 当不同字符数量超过 k 时，收缩左边界
19            while (countMap.size() > k) {
20                char lChar = s.charAt(left);
21                countMap.put(lChar, countMap.get(lChar) - 1);
22                if (countMap.get(lChar) == 0) {
23                    countMap.remove(lChar);
24                }
25                left++;
26            }
27
28            // 更新满足条件的最大长度
29            maxLen = Math.max(maxLen, right - left + 1);
30        }
31
32        return maxLen;
33    }
34}