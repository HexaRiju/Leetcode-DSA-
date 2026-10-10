class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int currSmall = points[0][1], count = 1, i = 0;
        while(i < points.length){
            if(!(points[i][0] <= currSmall && points[i][1] >= currSmall)){
                currSmall = points[i][1];
                count++;
            }
            i++;
        }
        return count;
    }
}