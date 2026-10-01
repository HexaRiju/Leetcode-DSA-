class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        if(nums.length == 1)
            return 0;
        for(int i = 0; i < nums.length; i++){
            int diff = k - nums[i];
            if(diff < 1)
                continue;
            if(map.containsKey(diff)){
                maxCount++;
                map.put(diff, map.getOrDefault(diff, 0) - 1);
                if(map.get(diff) == 0)
                    map.remove(diff);
            }
            else
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return maxCount;
    }
}