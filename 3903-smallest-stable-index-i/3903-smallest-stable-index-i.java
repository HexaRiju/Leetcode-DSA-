class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] prefixMax = new int[nums.length];
        int[] suffixMin = new int[nums.length];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, minIndex = Integer.MAX_VALUE;
        int i = 0, j = nums.length - 1;
        while(i < nums.length && j >= 0){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[j]);
            prefixMax[i] = max;
            suffixMin[j] = min;
            i++;
            j--;
        }
        for(int p = 0; p < nums.length; p++){
            int instable = prefixMax[p] - suffixMin[p];
            if(instable <= k){
                minIndex = Math.min(minIndex, p);
            }
        }
        if(minIndex != Integer.MAX_VALUE)
            return minIndex;
        return -1;
    }
}