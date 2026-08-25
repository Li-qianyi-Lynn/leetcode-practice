1class Solution {
2    public List<Integer> findSubstring(String s, String[] words) {
3        List<Integer> res = new ArrayList<>();
4        Map<String, Integer> map = new HashMap<>();
5        int n = words.length;
6        int wordLen = words[0].length();
7
8        for (String word : words) {
9            map.put(word, map.getOrDefault(word,0)+1);
10        }
11        
12        // ... 前面初始化 map 的逻辑保持不变 ...
13
14        for (int i = 0; i < wordLen; i++) {
15            int l = i;
16            int r = i;
17            Map<String, Integer> windowMap = new HashMap<>();
18
19            while (r + wordLen <= s.length()) {
20                String cur = s.substring(r, r + wordLen);
21                r += wordLen;
22
23                if (map.containsKey(cur)) {
24                    windowMap.put(cur, windowMap.getOrDefault(cur, 0) + 1);
25
26                    // 如果当前单词多了，收缩左边界直到频率合法
27                    while (windowMap.get(cur) > map.get(cur)) {
28                        String leftWord = s.substring(l, l + wordLen);
29                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
30                        l += wordLen;
31                    }
32
33                    // --- 关键修改处 ---
34                    // 因为上面的 while 保证了窗口内全是合法单词且频率不超标
35                    // 所以只要长度达标，就意味着找到了一个排列
36                    if (r - l == n * wordLen) {
37                        res.add(l);
38                    }
39                } else {
40                    // 遇到不在词典里的词，重置窗口
41                    l = r;
42                    windowMap.clear();
43                }
44            }
45        }
46        return res;
47
48    }
49}
50
51/**
52slide window:
53words same
54count same
55Hashmap<Char -> Integer>
56
570,1,2 iterate word.len
58l: r
59
60
61
62
63 */