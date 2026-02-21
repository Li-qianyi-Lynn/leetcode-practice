1class Solution {
2    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
3        int maxCandies = 1;
4        for (int candy : candies) {
5            maxCandies = Math.max(candy, maxCandies);
6        }
7
8        List<Boolean> res = new ArrayList<>();
9        for (int candy : candies) {
10            if (candy + extraCandies >=  maxCandies) {
11                res.add(true);
12
13            } else {
14                res.add(false);
15            }
16
17        }
18        return res;
19        
20    }
21}