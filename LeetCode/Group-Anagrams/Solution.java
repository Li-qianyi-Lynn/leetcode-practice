1class Solution {
2    public List<List<String>> groupAnagrams(String[] strs) {
3        Map<String, List<String>> map = new HashMap<>();
4        List<List<String>> res = new ArrayList<>();
5
6        // 取每一个String 做key
7        for (String s : strs) {
8            char[] c = s.toCharArray();
9            Arrays.sort(c);
10            // String key = c.toString();  即使两个单词排序后的字符数组内容一模一样，它们的 toString() 返回值也不同。这会导致 map 无法正确分组，每个单词都会被存入不同的 key 下。
11            String key = String.valueOf(c);
12            map.putIfAbsent(key, new ArrayList<>());
13
14            map.get(key).add(s);
15        }
16 
17        res.addAll(map.values());
18        return res;
19   
20  
21    }
22}
23
24/**
25map:
26String(排序过的) -> List<String>
27
28 */