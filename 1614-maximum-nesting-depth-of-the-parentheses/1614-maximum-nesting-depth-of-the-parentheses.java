class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int maxCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                st.push(c);
            else if(c == ')'){
                maxCount = Math.max(maxCount, st.size());
                st.pop();
            }
            else
                continue;
        }
        return maxCount;
    }
}