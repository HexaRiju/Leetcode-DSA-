class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty())
                stack.push(s.charAt(i));
            else if(set(s.charAt(i),stack.peek()) == 1)
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        return stack.size() == 0;
    }
    public int set(char ch2, char ch1){
        if((ch1 == '(' && ch2 == ')')||(ch1 == '{' && ch2 == '}')||(ch1 == '[' && ch2 == ']'))
            return 1;
        else
            return 0;
    }
}