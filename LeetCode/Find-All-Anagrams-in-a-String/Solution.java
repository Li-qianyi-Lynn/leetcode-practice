1class Solution {
2    public List<Integer> findAnagrams(String s, String p) {
3       int[] mapS = new int[26];  //window
4        int[] mapP = new int[26];
5        int k = p.length();
6
7        
8        for (char c : p.toCharArray()) {
9            mapP[c-'a']++;
10        }
11        /**
12        
13        Input: s = "cbaebabacd", p = "abc"
14                     ｜
15                       |
16                     l:i-k
17        
18         */
19        
20        int n = s.length();
21        List<Integer> list = new ArrayList<>();
22        for (int i = 0; i < n; i++) {
23            // i add right.- window uodate
24            mapS[s.charAt(i) - 'a']++;
25            
26            // if i>=k  remove left -window update
27            if (i>=k) {
28                int idx = s.charAt(i-k) - 'a';
29                mapS[idx]--;
30            }
31            //  check boundary and compare if meet target
32
33            if (i >= k-1 && Arrays.equals(mapS,mapP)) {
34                list.add(i-k+1);
35                    
36            }
37        }
38        return list;
39
40
41
42    }
43}