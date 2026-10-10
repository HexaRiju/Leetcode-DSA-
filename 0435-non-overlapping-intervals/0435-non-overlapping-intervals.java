class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int i = 0, j = 1, count = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        while(j < intervals.length){
            if(intervals[i][1] > intervals[j][0]){
                count++;
                if(intervals[i][1] > intervals[j][1]){
                    i = j;
                    j++;
                }
                else
                    j++;
            }
            else{
                i = j;
                j++;
            }
        }
        return count;
    }
}