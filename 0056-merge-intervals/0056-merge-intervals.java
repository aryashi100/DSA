class Solution {
    public int[][] merge(int[][] intervals) {
         if (intervals.length == 0) {
            return new int[0][];
        }
        // Sort by starting point
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();

        // Start with the first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // Overlapping
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            }

            // Not overlapping
            else {
                ans.add(new int[]{start, end});

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add the last interval
        ans.add(new int[]{start, end});

        return ans.toArray(new int[ans.size()][]);
    }
}