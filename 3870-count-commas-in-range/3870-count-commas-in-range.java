class Solution {
    public int countCommas(int n) {
        int element = (int)(Math.floor(Math.log10(n))) + 1;
        if(element < 4)
            return 0;
        else{
            int x = (n - 1000) + 1;
            return x;
        }
    }
}