public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '['|| c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty() || Math.abs(stack.peek() - c) > 2) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();        
    }
}