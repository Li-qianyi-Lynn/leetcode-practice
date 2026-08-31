1class Solution {
2    public String simplifyPath(String path) {
3        // 1. 使用 Deque 模拟栈
4        Deque<String> stack = new ArrayDeque<>();
5        
6        // 2. 将路径按 "/" 分割成字符串数组
7        String[] components = path.split("/");
8        
9        for (String part : components) {
10            // 情况 A: 遇到 ".."，如果栈不为空则弹出（返回上一级）
11            if (part.equals("..")) {
12                if (!stack.isEmpty()) {
13                    stack.pollLast(); // 弹出最近进入的目录
14                }
15            } 
16            // 情况 B: 忽略 "."、空字符串（多个斜杠造成）
17            else if (part.equals(".") || part.isEmpty()) {
18                continue;
19            } 
20            // 情况 C: 合法的目录名，压入栈
21            else {
22                stack.offerLast(part);
23            }
24        }
25        
26        // 3. 构建最终的规范路径
27        StringBuilder result = new StringBuilder();
28        if (stack.isEmpty()) {
29            return "/";
30        }
31        
32        // Deque 的好处：可以从头开始遍历，方便按顺序拼接路径
33        while (!stack.isEmpty()) {
34            result.append("/").append(stack.pollFirst());
35        }
36        
37        return result.toString();
38    }
39}