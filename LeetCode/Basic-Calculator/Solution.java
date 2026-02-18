1/**
2(23+5) + 6
3
4 */
5class Solution {
6    public int calculate(String s) {
7        Deque<Integer> dq = new ArrayDeque<>();
8        int res = 0;    // 当前层级的累加结果
9        int sign = 1;   // 当前的符号：1 表示 +，-1 表示 -
10        int n = s.length();
11
12        for (int i = 0; i < n; i++) {
13            char c = s.charAt(i);
14
15            if (Character.isDigit(c)) {
16                // 1. 处理多位数字
17                int num = 0;
18                while (i < n && Character.isDigit(s.charAt(i))) {
19                    num = num * 10 + (s.charAt(i) - '0');
20                    // i++;
21                    if (i+1 < n && Character.isDigit(s.charAt(i+1))) {
22                        i++;
23                    } else {
24                        break;
25                    }
26                }
27                res += sign * num;
28                // i--; // 停止前多加了i
29            } else if (c == '+') {
30                sign = 1;
31            } else if (c == '-') {
32                sign = -1;
33            } else if (c == '(') {
34                // 2. 遇到左括号：保存现场
35                // 先存当前算好的结果，再存括号前的符号
36                dq.offerLast(res);
37                dq.offerLast(sign);
38                // 重置现场，准备算括号里的新表达式
39                res = 0;
40                sign = 1;
41            } 
42            else if (c == ')') {
43                // 3. 遇到右括号：恢复现场
44                // 括号里的算完了，先乘上括号外的符号
45                res *= dq.pollLast(); 
46                // 再加上括号前已经算好的结果
47                res += dq.pollLast();
48            }
49            // 其余字符如空格直接忽略
50        }
51        return res;
52    }
53}