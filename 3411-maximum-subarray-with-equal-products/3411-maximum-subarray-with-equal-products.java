class Solution {
    public int maxLength(int[] nums) {
        int len = 1, i = 0, j = 1, G = nums[0], L = nums[0], p = nums[0];
        while(j < nums.length){ 
            p = p * nums[j];
            G = gcd(G, nums[j]);
            L = (L * nums[j])/gcd(L, nums[j]);
            while(p != G * L){
                p = p / nums[i];
                i++;
                int G1 = GCD(i, j, nums);
                int L1 = LCM(i, j, nums);
                L = L1;
                G = G1;
            }
            len = Math.max(len, j - i + 1);
            j++;
        }
        return len;
    }
    public int GCD(int i, int j, int[] arr){
        int G1 = arr[i];
        for(int s = i + 1; s <= j; s++)
            G1 = gcd(G1, arr[s]);
        return G1;
    }
    public int LCM(int i, int j, int[] arr){
        int L1 = arr[i];
        for(int s = i + 1; s <= j; s++)
            L1 = (L1 * arr[s])/gcd(L1, arr[s]);
        return L1;
    }
    public int gcd(int a, int b){
        if(b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}