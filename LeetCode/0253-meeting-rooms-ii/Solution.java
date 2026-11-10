class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int room = 0;

        // 存开始时间和结束时间
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int endIndex = 0;
        for (int j = 0; j < n; j++) {
            if (starts[j] < ends[endIndex]) {
                room++;
            } else {
                endIndex++;
            }
        }
        return room;
        
    }
}

/**
开始时间 结束时间都记录下来 做个排序
比较在开始的时候有没有会议能结束，如果不能结束的话，room++


 */