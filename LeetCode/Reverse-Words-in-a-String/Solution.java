1class Solution {
2    public String reverseWords(String s) {
3        String[] words = s.trim().split("\\s+");
4        StringBuilder sb = new StringBuilder();
5        for (int i = words.length-1; i >= 0; i--) {
6            if (i == 0) {
7                sb.append(words[i]);
8            } else {
9                sb.append(words[i]).append(" ");
10            }
11
12        }
13        return sb.toString();
14        
15        
16    }
17}
18
19/**
20step1 : delete all space trim()+split String[]
21step2: use for loop to iterate String[] in reverse older, 
22-append the last word
23-others: word + [' '] 
24
25
26
27 */