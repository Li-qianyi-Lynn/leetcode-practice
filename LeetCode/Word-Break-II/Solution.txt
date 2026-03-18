1class Solution {
2    // 记忆化 Map：Key 是字符串的起始位置，Value 是从这个位置到末尾能拆分出的所有句子
3    Map<Integer, List<String>> memo = new HashMap<>();
4
5    public List<String> wordBreak(String s, List<String> wordDict) {
6        Set<String> set = new HashSet<>(wordDict);
7        return dfs(s, 0, set);
8    }
9
10    private List<String> dfs(String s, int start, Set<String> set) {
11        // 1. 如果之前算过这个位置，直接返回结果
12        if (memo.containsKey(start)) {
13            return memo.get(start);
14        }
15
16        List<String> res = new ArrayList<>();
17        int n = s.length();
18
19        // 2. 递归出口：如果到了末尾，返回一个包含空字符串的列表
20        // 这表示我们成功找到了一个完整的拆分方式
21        if (start == n) {
22            res.add("");
23            return res;
24        }
25
26        // 3. 尝试各种切分
27        for (int i = start + 1; i <= n; i++) {
28            String word = s.substring(start, i);
29            
30            if (set.contains(word)) {
31                // 如果当前前缀是单词，递归获取剩余部分的所有拆分结果
32                List<String> nextPaths = dfs(s, i, set);
33                
34                // 4. 将当前单词与后面的结果拼接
35                for (String path : nextPaths) {
36                    if (path.isEmpty()) {
37                        res.add(word); // 刚好拼到末尾
38                    } else {
39                        res.add(word + " " + path); // 单词之间加空格
40                    }
41                }
42            }
43        }
44
45        // 5. 存入记忆化 Map 并返回
46        memo.put(start, res);
47        return res;
48    }
49}