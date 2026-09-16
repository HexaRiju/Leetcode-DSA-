class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return calculate(rec1, rec2) && calculate(rec2, rec1);
    }
    public boolean calculate(int[] r1, int[] r2){
        if(r1[3] > r2[1] && r1[2] > r2[0])
            return true;
        else if(r1[3] > r2[1] && r2[2] > r1[0] && r2[0] < r1[2])
            return true;
        return false;
    }
}