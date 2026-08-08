1class Solution {
2    public List<List<String>> groupAnagrams(String[] strs) {
3        List<List<String>> res = new ArrayList<>();
4        // edge case
5        // if (strs.length == 1) {
6        //     return new ArrayList<>(strs); // todo
7
8        // }
9        int n = strs.length;
10        HashMap<String, List<String>> map = new HashMap<>();
11        for (int i = 0; i < n; i++) {
12            String cur = strs[i];
13            char[] curChar = cur.toCharArray();
14            Arrays.sort(curChar);
15            map.putIfAbsent(String.valueOf(curChar), new ArrayList<>());
16            map.get(String.valueOf(curChar)).add(cur);
17        }
18
19        // res.add(map.values()); //todo
20        // return res;
21        return new ArrayList<>(map.values());
22        
23        
24    }
25}
26/**
27hashmap
28eat -> [word]
29
30 */