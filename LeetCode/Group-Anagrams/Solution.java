1class Solution {
2    public List<List<String>> groupAnagrams(String[] strs) {
3        List<List<String>> res = new ArrayList<>();
4        Map<String, List<String>> map = new HashMap<>();
5        for (String s : strs) {
6            char[] chars = s.toCharArray();
7            Arrays.sort(chars);
8            String k = String.valueOf(chars);
9            map.putIfAbsent(k, new ArrayList<>());
10            map.get(k).add(s);
11        }
12        res.addAll(map.values());
13        return res;
14        
15        
16    }
17}