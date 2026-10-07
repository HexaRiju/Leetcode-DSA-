class Solution {
    public int maxVowels(String s, int k) {
        int i = 0, j = 0, maxLength = Integer.MIN_VALUE, length = 0;
        while(j < k){
            char c = s.charAt(j);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                length++;
            j++;
        }
        j -= 1;
        maxLength = length;
        while(j < s.length() - 1){
            char cPrev = s.charAt(i);
            if(cPrev == 'a' || cPrev == 'e' || cPrev == 'i' || cPrev == 'o' || cPrev == 'u')
                length -= 1;
            i++;
            j++;
            char cNext = s.charAt(j);
            if(cNext == 'a' || cNext == 'e' || cNext == 'i' || cNext == 'o' || cNext == 'u')
                length += 1;
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }
}