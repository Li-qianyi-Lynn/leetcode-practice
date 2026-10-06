1class Solution {
2    public String decodeString(String s) {
3        // stack 存放 int[]{count, startIndex}
4        Deque<int[]> stack = new ArrayDeque<>();
5        StringBuilder res = new StringBuilder();
6        int count = 0;
7
8        for (char ch : s.toCharArray()) {
9            if (Character.isDigit(ch)) {
10                count = count * 10 + (ch - '0');
11            } else if (ch == '[') {
12                // 记录进入当前括号时的 repeatCount 和在 res 中的起始位置
13                stack.push(new int[]{count, res.length()});
14                count = 0;
15            } else if (ch == ']') {
16                int[] top = stack.pop();
17                int repeatTimes = top[0];
18                int start = top[1];
19
20                // 提取当前括号内刚刚生成的字符串
21                String segment = res.substring(start);
22                
23                // 该段原本已经存在 1 份，所以只需额外追加 (repeatTimes - 1) 次
24                for (int i = 0; i < repeatTimes - 1; i++) {
25                    res.append(segment);
26                }
27            } else {
28                res.append(ch);
29            }
30        }
31
32        return res.toString();
33    }
34}