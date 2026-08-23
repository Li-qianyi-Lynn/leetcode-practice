1class Solution {
2    public int lengthOfLongestSubstringKDistinct(String s, int k) {
3        if (k == 0) {
4            return 0;
5
6        }
7        HashMap<Character, Integer> map = new HashMap<>();
8        int l = 0;
9        int n = s.length();
10        int res = 0;
11        for (int r = 0; r < n; r++) {
12            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
13            while (map.size() > k) {
14                char c = s.charAt(l);
15                map.put(c,map.get(c)-1);
16                if (map.get(c) == 0) {
17                    map.remove(c);
18                }
19                l++;
20            }
21            res = Math.max(r-l+1, res);
22        }
23        return res;
24        
25    }
26}
27/**
28
29sliding window
30set
31eceba
32｜
33  ｜
34
35compare set.size() with k
36valid: size <= k
37invalid: size > k
38move left pointer, update set
39
40
41 */