1class Solution {
2    public String reverseWords(String s) {
3        String[] words = s.trim().split("\\s+");
4        StringBuilder sb = new StringBuilder();
5        for (int i = words.length-1; i >= 0; i--) {
6            if (i == 0) {
7                sb.append(words[i]);
8
9            } else {
10                sb.append(words[i]).append(" ");
11
12            }
13           
14        }
15        return sb.toString();
16        
17
18    }
19}
20
21/***
221. split space
232. for loop：把string + space 加到stringbuilder 里，删去最后一个space
24
25
26
27 */