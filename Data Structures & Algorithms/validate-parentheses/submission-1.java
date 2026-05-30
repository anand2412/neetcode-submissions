class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) {
            return true;
        }
        if(s.length() == 1) {
            return false;
        }
        Stack<Character> st =new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                if(ch == '}' && st.pop() != '{') {
                    return false;
                } else if (ch == ']' && st.pop() != '[') {
                    return false;
                } else if (ch == ')' && st.pop() != '(') {
                    return false;
                }
            }
        }
        return st.isEmpty() ? true : false;
    }
}
