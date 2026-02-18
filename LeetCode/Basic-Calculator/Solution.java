1
2
3class Solution {
4    public int calculate(String s) {
5        // 使用 Deque 作为栈
6        Deque<Integer> dq = new ArrayDeque<>();
7        int res = 0;    // 当前层级的累加结果
8        int sign = 1;   // 当前的符号：1 表示 +，-1 表示 -
9        int n = s.length();
10
11        for (int i = 0; i < n; i++) {
12            char c = s.charAt(i);
13
14            if (Character.isDigit(c)) {
15                // 1. 处理多位数字
16                int num = 0;
17                while (i < n && Character.isDigit(s.charAt(i))) {
18                    num = num * 10 + (s.charAt(i) - '0');
19                    i++;
20                }
21                // 算出这个数后，立刻根据符号加到结果里
22                res += sign * num;
23                i--; // 补偿 for 循环的 i++
24            } 
25            else if (c == '+') {
26                sign = 1;
27            } 
28            else if (c == '-') {
29                sign = -1;
30            } 
31            else if (c == '(') {
32                // 2. 遇到左括号：保存现场
33                // 先存当前算好的结果，再存括号前的符号
34                dq.offerLast(res);
35                dq.offerLast(sign);
36                // 重置现场，准备算括号里的新表达式
37                res = 0;
38                sign = 1;
39            } 
40            else if (c == ')') {
41                // 3. 遇到右括号：恢复现场
42                // 括号里的算完了，先乘上括号外的符号
43                res *= dq.pollLast(); 
44                // 再加上括号前已经算好的结果
45                res += dq.pollLast();
46            }
47            // 其余字符如空格直接忽略
48        }
49        return res;
50    }
51}