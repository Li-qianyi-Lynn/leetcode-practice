1class Solution {
2    Map<Integer, List<String>> map = new HashMap<>();// start index 
3    public List<String> wordBreak(String s, List<String> wordDict) {
4        Set<String> set = new HashSet<>(wordDict);
5        return dfs(s,set,0);
6        
7    }
8    private List<String> dfs(String s, Set<String> set, int i) {
9        List<String> res = new ArrayList<>();
10        // base case
11        if (map.containsKey(i)) {
12            return map.get(i);
13        }
14
15        int len = s.length();
16        if (i == len) {
17            res.add("");
18            return res;
19        }
20
21        for (int end = i+1; end <= len; end++) {
22            String cur = s.substring(i,end);
23            if (set.contains(cur)) {
24
25                List<String> next = dfs(s,set,end);
26                for (String nex : next) {
27                    if (nex.isEmpty()) {
28                        res.add(cur);
29
30                    } else {
31                        res.add(cur + " " + nex);
32                    }  
33                }
34            }
35        }
36        map.put(i, res);
37        return res;
38
39    }
40}
41/**
42cut dicts
43start index end index
44
45memo = m
46dfs: 重复的字问题
47
48
49
50 */