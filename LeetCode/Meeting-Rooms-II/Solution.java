class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Map<Integer, Integer> map = new HashMap<>(); //time，-1/1
        // for (int[] interval : intervals) {
        //     map.put(interval[0],1);
        //     map.put(interval[1],-1);
        // }

        // TreeMap<Integer, Integer> treemap = new TreeMap<>(map);
        // int max = Integer.MIN_VALUE;
        // int room = 0;

        // for (int value : treemap.values()) {
        //     room += value;
        //     max = Math.max(room, max);
        // }

        // return max;
        
        List<int[]> events = new ArrayList<>();

        for (int[] interval : intervals) {
            events.add(new int[]{interval[0],1});
            events.add(new int[]{interval[1],-1});
        }

        events.sort((a,b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];

    });

        int rooms = 0;
        int max = 0;

        for (int[] event : events) {
            rooms += event[1];
            max = Math.max(max, rooms);

        }

        return max;


    }
}