class Solution {
    public int findDuplicate(int[] nums) {
        int correct = 0, index = 0;
        while(index < nums.length){
            correct = nums[index] - 1;
            if(nums[correct] != nums[index]){
                int temp = nums[correct];
                nums[correct] = nums[index];
                nums[index] = temp;
            }
            else
                index++;
        }
        index = 0;
        while(index < nums.length){
            if(index != nums[index] - 1)
                return nums[index];
            index++;
        }
        return -1;
    }
}