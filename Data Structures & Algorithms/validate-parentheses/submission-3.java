class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        int fc = s.charAt(0);
        if(fc == '}' || fc == ')' || fc == ']') return false;
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch == '[' || ch == '{' || ch == '(') st.push(ch);
            else if(ch == '}') {
                if(st.isEmpty() || st.peek() != '{') return false;
                else st.pop();
            } else if(ch == ')') {
                if(st.isEmpty() || st.peek() != '(') return false;
                else st.pop();
            } else if(ch == ']') {
                if(st.isEmpty() || st.peek() != '[') return false;
                else st.pop();
            }
        }

        return st.isEmpty();
    }
}
