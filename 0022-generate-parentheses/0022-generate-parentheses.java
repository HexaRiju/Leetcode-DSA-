class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String s = "";
        validCombo(0, 0, n, s, list);
        return list;
    }
    public void validCombo(int open, int close, int n, String s, List<String> list){
        if(open == n && close == n){
            list.add(s);
            return;
        }
        if(open < n){
            // String x = s;
            // s = s + "(";
            validCombo(open + 1, close, n, s + "(", list);
            // s = x;
        }
        if(close < open){
            // String x = s;
            // s = s + ")";
            validCombo(open, close + 1, n, s + ")", list);
            // s = x;
        }
        return;
    }
}