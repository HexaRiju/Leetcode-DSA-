class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] current = intervals[0];
        res.add(current);
        for(int[] interval : intervals){
            if(current[1] >= interval[0])
                current[1] = Math.max(current[1], interval[1]);
            else{
                current = interval;
                res.add(current);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}