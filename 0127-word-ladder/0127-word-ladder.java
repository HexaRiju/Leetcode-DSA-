class Pair{
    String s;
    int val;
    Pair(String s, int val){
        this.s = s;
        this.val = val;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : wordList)
            map.put(s, map.getOrDefault(s, 0) + 1);
        if(!map.containsKey(beginWord))
            map.put(beginWord, 1);
        if(!map.containsKey(endWord))
            return 0;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(beginWord, 1));
        while(!queue.isEmpty()){
            String s = queue.peek().s;
            int val = queue.peek().val;
            if(s.equals(endWord))
                return val;
            queue.remove();
            map.remove(s);
            char[] c = s.toCharArray();
            for(int i = 0; i < s.length(); i++){//O(m)
                char p = c[i];
                for(int j = 97; j <= 122; j++){
                    char t = (char)j;
                    if(p != t){
                        c[i] = t;
                        String scr = new String(c);// O(m)
                        if(map.containsKey(scr))
                            queue.add(new Pair(scr, val + 1));
                    }
                    c[i] = p;
                } 
            }
        }
        return 0;
    } // T.C = O(m^2 * n)
}