class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(String op: operations) {
            switch(op) {
                case "+":
                int top = st.pop();
                int newTop = top + st.peek();
                st.push(top);
                st.push(newTop);
                break;
                case "C":
                st.pop();
                break;
                case "D":
                int newRecord = 2 * st.peek();
                st.push(newRecord);
                break;
                default:st.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for(int num : st) {
            sum += num;
        }
        return sum;
    }
}