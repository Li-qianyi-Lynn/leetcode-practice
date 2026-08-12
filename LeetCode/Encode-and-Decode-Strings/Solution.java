1public class Codec {
2    public String encode(List<String> strs) {
3        if (strs.isEmpty()) return "";
4        StringBuilder sb = new StringBuilder();
5        for (String str : strs) {
6            sb.append(str.length()).append('/').append(str);
7        }
8        return sb.toString();
9    }
10
11    public List<String> decode(String str) {
12        if (str.length() == 0) {
13            return new ArrayList<>();
14        }
15        List<String> res = new ArrayList<>();
16        int i = 0;
17        while (i < str.length()) {
18            int j = i;
19            while (str.charAt(j) != '/') {
20                j++;
21            }
22            int length = Integer.parseInt(str.substring(i, j));
23            i = j + 1;
24            j = i + length;
25            res.add(str.substring(i, j));
26            i = j;
27        }
28        return res;
29
30
31    }
32}
33
34// Your Codec object will be instantiated and called as such:
35// Codec codec = new Codec();
36// codec.decode(codec.encode(strs));
37