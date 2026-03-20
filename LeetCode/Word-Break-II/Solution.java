1class Solution {
2    Map<Integer, List<String>> map = new HashMap<>();
3
4    public List<String> wordBreak(String s, List<String> wordDict) {
5        Set<String> set = new HashSet<>(wordDict);
6        return dfs(s,set,0); //
7        
8    }
9
10    private List<String> dfs (String s, Set<String> set, int start) {
11        List<String> res = new ArrayList<>();
12
13        // base case
14        if (map.containsKey(start)) {
15            return map.get(start);
16        }
17        int len = s.length();
18
19        if (start == len) {
20            res.add(""); //success signal
21            return res;
22        }
23
24        for (int end = start+1; end <= len; end++) {
25            String cur = s.substring(start,end);
26            if (set.contains(cur)) {
27                List<String> next = dfs(s,set,end);
28                
29                for (String ne : next) {
30                    if (ne.isEmpty()) {
31                        res.add(cur);
32
33                    } else {
34                        res.add(cur + " " + ne);
35                    }
36                
37                }
38            }
39
40        }
41        map.put(start,res);
42        return res;
43
44    }
45}
46/**
47left s can be divided or not
48memo  start -> list<String>
49
50dfs
51
52
53 */
54