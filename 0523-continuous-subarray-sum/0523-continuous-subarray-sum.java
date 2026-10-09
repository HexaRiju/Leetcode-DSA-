class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();// the key is prefixSum % k, and the value is the size of the prefix array.
        int prefixSum = 0;
        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            int key = prefixSum % k;
            if(key == 0 && i + 1 >= 2)
                return true;
            if(map.containsKey(key) && (i + 1) - map.get(key) >= 2)
                return true;
            else{
                if(map.containsKey(key) && map.get(key) > i + 1)
                    map.put(key, i + 1);
                else if(!map.containsKey(key))
                    map.put(key, i + 1);
            }
        }
        return false;
    }
}