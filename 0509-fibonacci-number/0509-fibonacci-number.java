class Solution {
    public int fib(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return answer(n, map);
    }
    public int answer(int n, Map<Integer, Integer> map){
        if(n == 0 || n == 1)
            return n;
        if(map.containsKey(n))
            return map.get(n);
        int ans = answer(n - 1, map) + answer(n - 2, map);
        map.put(n, ans);
        return ans;
    }
}