1class Solution {
2    public boolean wordPattern(String pattern, String s) {
3        String[] sp = s.split(" ");
4        int[] target = new int[26];
5        Arrays.fill(target, -1);
6        Map<String, Integer> map = new HashMap<>();
7
8        if (sp.length != pattern.length()) {
9            return false;
10
11        }
12        for (int i = 0; i < pattern.length();i++) {
13            int idx = pattern.charAt(i) - 'a';
14            if (target[idx] != map.getOrDefault(sp[i],-1)) {
15                return false;
16            }
17
18            target[idx] = i;
19            map.put(sp[i],i);
20        } 
21        return true;
22        
23    }
24}