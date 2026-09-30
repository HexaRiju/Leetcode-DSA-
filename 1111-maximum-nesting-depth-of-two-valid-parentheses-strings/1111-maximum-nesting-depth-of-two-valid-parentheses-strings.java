class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        if(seq.length() == 1)
            return res;
        else{
            int depth = 0;
            for(int i = 0; i < seq.length(); i++){
                if(seq.charAt(i) == '('){
                    depth++;
                    if(depth % 2 != 0)
                        res[i] = 0;
                    else
                        res[i] = 1;
                }
                else if(seq.charAt(i) == ')'){
                    depth--;
                    if(depth % 2 != 0)
                        res[i] = 1;
                    else
                        res[i] = 0;
                }
            }
            return res;
        }
    }
}