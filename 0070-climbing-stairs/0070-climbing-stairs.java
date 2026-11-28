class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return fun(n, 0, map);
    }
    public int fun(int n, int i, Map<Integer, Integer> map){
        if(n == i)
            return 1;
        else if(n < i)
            return 0;
        if(map.containsKey(i))
            return map.get(i);
        int a1 = fun(n, i + 1, map);
        int a2 = fun(n, i + 2, map);
        map.put(i, a1 + a2);
        return a1 + a2;
    }
}