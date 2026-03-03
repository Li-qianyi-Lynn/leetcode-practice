1class Solution {
2    public List<List<String>> groupAnagrams(String[] strs) {
3        List<List<String>> res = new ArrayList<>();
4        Map<String,List<String>> map = new HashMap<>();
5
6        for (String s : strs) {
7            char[] c = s.toCharArray();
8            Arrays.sort(c);
9            String key = String.valueOf(c);
10            map.putIfAbsent(key, new ArrayList<>());
11            map.get(key).add(s);
12        }
13        res.addAll(map.values());
14        return res;
15        
16    }
17}
18/**
19
20char + num 
21
22get the string 
23eat tae  sorted -> aet: eat tea ate 
24
25
26 */