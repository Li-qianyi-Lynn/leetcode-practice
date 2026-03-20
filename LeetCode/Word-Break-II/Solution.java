1class Solution {
2    private Map<Integer, List<String>> memo = new HashMap<>();
3    public List<String> wordBreak(String s, List<String> wordDict) {
4        Set<String> set = new HashSet<>(wordDict);
5        return dfs(s, set, 0); // todo 
6        
7    }
8
9    private List<String> dfs (String s, Set<String> set, int start) {
10        int len = s.length();
11        List<String> res = new ArrayList<>();
12        
13        // pruning
14        if (memo.containsKey(start)) {
15            return memo.get(start);
16        }
17        //base case
18        if (start == len) {
19            res.add("");
20            return res;
21        }
22
23        // recursion rules -> start, end index
24        for (int end = start+1;end <= len; end++) {
25            String cur = s.substring(start,end);
26            if (set.contains(cur)) { // find a word
27                List<String> next = dfs(s,set,end);
28                for (String ne : next) {
29                    if (ne.isEmpty()) {
30                        res.add(cur);
31                    } else {
32                        res.add(cur + " " + ne);
33                    }
34                }
35            }
36        }
37        memo.put(start,res);
38        return res;
39
40        // how to divide -> 切割成功，dfs,end -> start index
41    }
42}
43/**
44input; strings, list<String>
45output: List<String>
46
471. add space: divide -> dfs // start end idex 
482. words in worddict  -> set
49
50recursion
51// base case
52
53// recursion rules
54
55
56// how to divide 
57
58memo: Map<> start -> list<String>
59
60 */