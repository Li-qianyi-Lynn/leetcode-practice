1class Solution {
2    public String reverseWords(String s) {
3        StringBuilder sb = new StringBuilder();
4        String[] words = s.trim().split("\\s+");
5        for (int i = words.length-1; i >= 0;i--) {
6            if (i == 0) {
7                sb.append(words[i]);
8
9            } else {
10                sb.append(words[i]).append(" ");
11            }
12        }
13        return sb.toString();
14        
15    }
16}