class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = intervals.length - 1;
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        while(i >= 0){
            if(intervals[i][0] <= newInterval[0])
                break;
            i--;
        }
        list.add(i + 1, newInterval);
        List<int[]> res = new ArrayList<>();
        int[] current = list.get(0);
        res.add(current);
        for(int[] interval : list){
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