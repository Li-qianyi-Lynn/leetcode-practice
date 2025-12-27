1class Solution {
2    public List<List<String>> groupAnagrams(String[] strs) {
3        
4        List<List<String>> res = new ArrayList<>();
5        HashMap<String, List<String>> map = new HashMap<>();
6
7        // take each word 
8        for (String s : strs) {
9            int[] count = new int[26];
10            for (char c : s.toCharArray()) {
11                count[c-'a']++;
12            }
13
14            String key = Arrays.toString(count);
15            // if no keys, new arrayList<>()
16            map.putIfAbsent(key, new ArrayList<>());
17            map.get(key).add(s);
18        }
19
20        res.addAll(map.values());
21        return res;
22  
23    }
24}
25
26/**
27
28use hashmap to store group anagrams
29key: String - which means it has same char groups
30-convert 26 english letters as int[26]
31-index means a-z
32-int[i] means the num of letters used
33
34values: List<String> - anagrams
35
36if map has the key, add the value;
37or map. putifabsent (new key, new values )
38
39
40return map. values as the res (collections)
41or addAll
42
43
44
45
46 */