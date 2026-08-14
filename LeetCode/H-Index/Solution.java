1class Solution {
2    public int hIndex(int[] citations) {
3        int n = citations.length;
4
5        // count[i] = number of papers with i citations
6        // citations >= n are put into count[n]
7        int[] count = new int[n + 1];
8
9        for (int citation : citations) {
10            if (citation >= n) {
11                count[n]++;
12            } else {
13                count[citation]++;
14            }
15        }
16
17        // papers = number of papers with citation >= h
18        int papers = 0;
19
20        for (int h = n; h >= 0; h--) {
21            papers += count[h];
22
23            if (papers >= h) {
24                return h;
25            }
26        }
27
28        return 0;
29    }
30}
31/**
32input: int[]
33output: int: h-idx
34            
35citations = [3,0,6,1,5]
36             0  1 2 3 4
37
38h: 
391. h <= len of citations 1-5 12345
402. citations[i] >= h
41
42符合h-idx 要求
43h-idx     understanding
441         1 paper 1 citation
452         2 paper each 2 citations
463         3 paper each 3 citations
47
48
491-5 inorder -> binary search
50l = 1
51r = 5
52
53
54
55 */