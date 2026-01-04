1class Solution {
2    public int longestMountain(int[] arr) {
3        int n = arr.length; // index
4        int maxRes = 0;
5        int l = 0;
6        // start - peak - foot - update res
7        while (l+2 < n) {
8
9            if (arr[l] >= arr[l + 1]) {
10                l++;
11                continue;
12            }
13
14            int r = l;
15            while (r+1 < n && arr[r] < arr[r+1] ) {
16                r++;
17            }
18            // going down
19
20            if (r+1 < n && arr[r] > arr[r+1]) {
21                while (r+1 < n && arr[r] > arr[r+1]) {
22                    r++;
23                }
24                maxRes = Math.max(maxRes, r-l+1);
25                l = r;
26
27            } else {
28                l = r+1;
29            }
30        }
31        
32        return maxRes;       
33    }
34}
35
36/***
37
382 1 4 7 5 6 7 8 9 8 7 6
39        r r+1
40
41 */