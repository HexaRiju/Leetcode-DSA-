class Solution {
    public String longestPalindrome(String s) {
        int j = 1, max = 0;
        int[] arr = new int[2];
        String res = "";
        while (j <= s.length()) {
            for(int i = 0; i < j; i++){
                String sub = s.substring(i, j);
                if (palindrome(sub)) {
                    if (max < sub.length()) {
                        res = sub;
                        max = sub.length();
                    }
                }
            }
            j++;
        }
        return res;
    }

    public boolean palindrome(String sub) {
        int i = 0, j = sub.length() - 1;
        while (i < j) {
            if (sub.charAt(i) != sub.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}