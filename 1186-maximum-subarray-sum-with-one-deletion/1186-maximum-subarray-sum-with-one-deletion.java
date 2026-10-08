class Solution {
    public int maximumSum(int[] arr) {
        // the S_e is represent the set of the element have the currnt best possible sum deleting one element e,
        // S will represent an set represent the best possible sum without any deletion.
        // res is the result that sotores the max sum that come before current state,
        int S = arr[0], S_e = Integer.MIN_VALUE, res = arr[0];
        for(int i = 1; i < arr.length; i++){
            int prevS = S;
            int prevS_e = S_e;
            S = Math.max(prevS + arr[i], arr[i]);// normal kaden's
            if(S_e == Integer.MIN_VALUE){
                S_e = arr[i];
            }
            else{
                S_e = prevS_e + arr[i];
            }
            S_e = Math.max(S_e , prevS);
            res = Math.max(res, Math.max(S, S_e));
        }
        return res;
    }
}