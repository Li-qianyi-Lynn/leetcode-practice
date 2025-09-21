class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {// O(nlogn)

    // 题目给的是 starttime， duration 和 volume
    // 其实 endtime = starttime + duration，这边需要小小改动
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            intervals.add(new int[]{startTime[i], endTime[i], profit[i]});
        }
        Collections.sort(intervals, new Comparator<int[]>() {// O(nlogn)
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[1] - i2[1];
            }
        });

        List<int[]> profitsStarts = new ArrayList<>();// int[]{starting from time t, max profits}
        profitsStarts.add(new int[]{0, 0});

        for (int[] interval : intervals) {// O(n)
            int[] lastProfit = profitsStarts.get(profitsStarts.size() - 1);
            int prevMaxProfit = this.findMaxProfit(profitsStarts, 0, profitsStarts.size() - 1, interval[0]);// O(logn)
            int possbileMaxProfit = prevMaxProfit + interval[2];
            if (lastProfit[1] > possbileMaxProfit) {
                continue;
            }

            if (lastProfit[0] == interval[1]) {
                lastProfit[1] = Math.max(lastProfit[1], possbileMaxProfit);
                continue;
            }
            // lastProfit[0] < interval[1]
            profitsStarts.add(new int[]{interval[1], possbileMaxProfit});
        }
        return profitsStarts.get(profitsStarts.size() - 1)[1];
    }
    private int findMaxProfit(List<int[]> profitsStarts, int left, int right, int startTime) {
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (profitsStarts.get(mid)[0] <= startTime) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return profitsStarts.get(left)[1];
    }
}