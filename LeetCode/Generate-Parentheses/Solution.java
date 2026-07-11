1class Solution {
2    List<String> res = new ArrayList<>();
3    public List<String> generateParenthesis(int n) {
4        if (n <= 0) {
5            return null;
6        }
7        StringBuilder sb = new StringBuilder();
8        backtracking(n,0,0,sb);
9        return res;
10
11
12
13
14
15        
16    }
17
18    private void backtracking(int n, int left, int right, StringBuilder sb) {
19        if (sb.length() == 2 * n) {
20            res.add(sb.toString());
21            return;
22        }
23
24        //left 
25        if (left < n) {
26            sb.append('(');
27            backtracking(n, left+1, right,sb);
28            sb.setLength(sb.length()-1);
29
30        }
31        // right
32        if (right < left) {
33            sb.append(')');
34            backtracking(n, left, right+1,sb);
35            sb.setLength(sb.length()-1);
36
37        }
38
39    }
40}
41/**
42rules:
43
44left: left( num < n, can add
45right: number of right < left, can add
46
47backtracking
48
49base case: res.size() == 2 * n return 
50
51
52 */