class Pair {
    char c;
    int listSizeAfterp;

    Pair(char c, int listSizeAfterp) {
        this.c = c;
        this.listSizeAfterp = listSizeAfterp;
    }
}

class Solution {
    public String reverseParentheses(String s) {
        List<Character> ch1 = new ArrayList<>();
        Stack<Pair> ch = new Stack<>();
        for(int j = 0; j < s.length(); j++){
            if(s.charAt(j) == '('){
                Pair p = new Pair(s.charAt(j), ch1.size());
                ch.push(p);
            }
            else if(s.charAt(j) ==')'){
                Pair p = ch.pop();
                operation(ch1.size() - p.listSizeAfterp, ch1);
            }
            else{
                ch1.add(s.charAt(j));
            }
        }
        String res = "";
        for(int j = 0; j < ch1.size(); j++){
            res += ch1.get(j);
        }
        return res;
    }
    public void operation(int i, List<Character> ch){
        Deque<Character> dq = new ArrayDeque<>();
        while(i > 0){
            dq.addLast(ch.remove(ch.size() - 1));
            i--;
        }
        while(!dq.isEmpty()){
            ch.add(dq.pop());
        }
    }
}