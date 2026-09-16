class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length, maxLeft = Integer.MIN_VALUE, minRight = Integer.MAX_VALUE, res = -1;
        int[] prefixMax = new int[n], suffixMin = new int[n];
        for(int i = 0; i < n; i++){
            maxLeft = Math.max(maxLeft, nums[i]);
            minRight = Math.min(minRight, nums[n - 1 - i]);
            prefixMax[i] = maxLeft;
            suffixMin[n - i - 1] = minRight;
        }
        for(int i = 0; i < n; i++){
            int ins = prefixMax[i] - suffixMin[i];
            if(ins <= k){
                if(res == -1)
                    res = i;
                res = Math.min(res, i);
            }
        }
        return res;
    }
}