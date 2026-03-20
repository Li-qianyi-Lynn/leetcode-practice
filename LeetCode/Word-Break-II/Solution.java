1class Solution {
2    public List<String> wordBreak(String s, List<String> wordDict) {
3        int n = s.length();
4    Set<String> wordSet = new HashSet<>(wordDict);
5    
6    // dp[i] 存储 s.substring(0, i) 的所有合法拆分方案
7    List<String>[] dp = new ArrayList[n + 1];
8    for (int i = 0; i <= n; i++) {
9        dp[i] = new ArrayList<>();
10    }
11
12    // 初始状态：空字符串的一种方案
13    dp[0].add("");
14
15    for (int i = 1; i <= n; i++) {
16        for (int j = 0; j < i; j++) {
17            String suffix = s.substring(j, i);
18            // 如果后缀在词典中，且前缀 dp[j] 有解
19            if (dp[j].size() > 0 && wordSet.contains(suffix)) {
20                for (String prev : dp[j]) {
21                    // 拼接：如果是第一个单词不加空格，否则加空格
22                    String join = prev.isEmpty() ? suffix : prev + " " + suffix;
23                    dp[i].add(join);
24                }
25            }
26        }
27    }
28
29    return dp[n];
30        
31    }
32}