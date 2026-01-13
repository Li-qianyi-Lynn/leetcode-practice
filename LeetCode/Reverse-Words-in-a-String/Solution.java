1class Solution {
2    public String reverseWords(String s) {
3        // delete spaces
4        String[] words = s.trim().split("\\s+");
5        StringBuilder sb = new StringBuilder();
6
7        for (int i = words.length-1; i>= 0; i-- ) {
8      
9            if (i == 0) {
10                sb.append(words[i]);
11            } else {
12                sb.append(words[i]).append(" ");
13            }
14
15        }
16        return sb.toString();
17        
18    }
19}
20/**
21
22step1:把所有空格都删除,保留这些word String[]
23step2: iterate string[], 从尾部开始遍历
24-几乎所有word+ ' ' [i]
25-最后一个word 不加空格
26
27*/