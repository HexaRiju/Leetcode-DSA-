class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('b', 0);
        map.put('c', 0);
        int i = 0, j = 0, count = 0;
        while(j < s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while(map.get('a') > 0 && map.get('b') > 0 && map.get('c') > 0){
                count += s.length() - j;
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                i++;
            }
            j++;
        }
        return count;
    }
}