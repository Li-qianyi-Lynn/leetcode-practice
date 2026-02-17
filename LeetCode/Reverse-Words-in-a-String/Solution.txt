1class Solution {
2    public String reverseWords(String s) {
3        String[] str = s.trim().split("\\s+");
4        StringBuilder sb = new StringBuilder();
5
6        for (int i = str.length-1; i >= 0;i--) {
7            if (i == 0) {
8                sb.append(str[i]);
9
10            } else {
11                sb.append(str[i]).append(' ');
12            }
13
14        }
15        return sb.toString();
16        
17    }
18}