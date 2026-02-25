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
12        for (int i = 0; i < wordLen; i++) {
13            int l = i;
14            int r = i;
15            int count = 0;
16            Map<String, Integer> windowMap = new HashMap<>();
17
18            while (r + wordLen <= s.length()) {
19                String cur = s.substring(r,r+wordLen);
20                r += wordLen; //move right pointer
21
22                if (map.containsKey(cur)) {
23                    windowMap.put(cur, windowMap.getOrDefault(cur,0)+1);
24                    count++;
25                    while (windowMap.get(cur)> map.get(cur)) {
26                        
27                        String leftWord = s.substring(l, l + wordLen);
28                        windowMap.put(leftWord, windowMap.get(leftWord)-1);
29                        l = l+ wordLen;
30                        count --;
31                    }
32
33                    if (count == n) {
34                        res.add(l);
35                    }   
36
37
38                } else {
39                    count = 0;
40                    l = r;
41                    windowMap.clear();
42                }
43            }
44
45    
46
47        }
48        return res;
49    }
50}
51
52/**
53slide window:
54words same
55count same
56Hashmap<Char -> Integer>
57
580,1,2 iterate word.len
59l: r
60
61
62
63
64 */