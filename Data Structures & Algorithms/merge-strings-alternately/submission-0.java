class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len = word1.length() > word2.length() ? word2.length() : word1.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(; i<len; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }

        while(i < word1.length()) sb.append(word1.charAt(i++));
        while(i < word2.length()) sb.append(word2.charAt(i++));

        return sb.toString();
    }
}