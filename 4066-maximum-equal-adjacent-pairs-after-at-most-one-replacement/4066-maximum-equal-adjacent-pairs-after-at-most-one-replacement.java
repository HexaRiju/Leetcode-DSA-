class Pair{
    int x,y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(!(obj instanceof Pair))
            return false;
        Pair p = (Pair)obj;
        return this.x == p.x && this.y == p.y;
    }
    public int hashCode(){
        return Objects.hash(x, y);
    }
}
class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int corrPair = 0, unequalPair = 0;
        Map<Pair, Integer> map = new HashMap<>();
        for(int i = 1; i < nums.length; i++){
            int x = Math.min(nums[i - 1], nums[i]), y = Math.max(nums[i - 1], nums[i]);
            if(x == y)
                corrPair++;
            else{
                Pair p = new Pair(x, y);
                map.put(p, map.getOrDefault(p, 0) + 1);
                unequalPair = Math.max(unequalPair, map.get(p));
            }
        }
        return corrPair + unequalPair;
    }
}