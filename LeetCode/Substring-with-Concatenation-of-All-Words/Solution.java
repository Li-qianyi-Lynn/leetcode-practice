1class Solution {
2    public List<Integer> findSubstring(String s, String[] words) {
3        List<Integer> res = new ArrayList<>();
4
5        int wordLen = words[0].length();
6        int wordNum = words.length;
7        int totalLen = wordLen * wordNum;
8        
9        // 1. 统计 words 中每个单词出现的次数
10        Map<String, Integer> wordCount = new HashMap<>();
11        for (String w : words) {
12            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
13        }
14
15        // 2. 只需要移动 wordLen 次，覆盖所有可能的起始对齐位置
16        for (int i = 0; i < wordLen; i++) {
17            int left = i, right = i;
18            int count = 0; // 当前窗口内有效单词的总数
19            Map<String, Integer> curMap = new HashMap<>();
20
21            // 3. 右指针滑动，每次跨越一个 wordLen
22            while (right + wordLen <= s.length()) {
23                String w = s.substring(right, right + wordLen);
24                right += wordLen;
25
26                if (wordCount.containsKey(w)) {
27                    curMap.put(w, curMap.getOrDefault(w, 0) + 1);
28                    count++;
29
30                    // 如果当前单词多了，左指针右移直到不多为止
31                    while (curMap.get(w) > wordCount.get(w)) {
32                        String leftWord = s.substring(left, left + wordLen);
33                        curMap.put(leftWord, curMap.get(leftWord) - 1);
34                        count--;
35                        left += wordLen;
36                    }
37
38                    // 窗口大小符合要求
39                    if (count == wordNum) {
40                        res.add(left);
41                    }
42                } else {
43                    // 遇到完全不在列表里的词，清空重新开始
44                    curMap.clear();
45                    count = 0;
46                    left = right;
47                }
48            }
49        }
50        return res;
51    }
52}
53
54/**
55多路并行的滑动窗口
56 */