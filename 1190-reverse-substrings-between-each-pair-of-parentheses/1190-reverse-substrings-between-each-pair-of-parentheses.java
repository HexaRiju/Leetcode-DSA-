class Solution {
    public String reverseParentheses(String s) {
        StringBuffer res = new StringBuffer("");
        Stack<StringBuffer> ch = new Stack<>();
        for(char p : s.toCharArray()){
            if(p == '('){
                ch.push(res);
                res = new StringBuffer("");
            }
            else if(p == ')'){
                res.reverse();
                StringBuffer prev = ch.pop();
                prev.append(res);
                res = prev;
            }
            else
                res.append(p);
        }
        return res.toString();
    }
}