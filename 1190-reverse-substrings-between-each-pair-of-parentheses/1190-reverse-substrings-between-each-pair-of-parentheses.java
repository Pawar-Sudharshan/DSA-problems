import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        return helper(s, 0, new Stack<Character>());
    }

    static String helper(String s, int idx, Stack<Character> stack) {
        int n = s.length();

        if (idx == n) {
            StringBuilder ans = new StringBuilder();
            while (!stack.isEmpty()) {
                ans.append(stack.pop());
            }
            return ans.reverse().toString();
        }

        char ch = s.charAt(idx);

        if (ch == ')') {
            StringBuilder temp = new StringBuilder();
            while (!stack.isEmpty() && stack.peek() != '(') {
                temp.append(stack.pop());
            }
            if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }
            for (int i = 0; i < temp.length(); i++) {
                stack.push(temp.charAt(i));
            }
            return helper(s, idx + 1, stack);
        }

        if (ch == '(') {
            stack.push(ch);
            return helper(s, idx + 1, stack);
        }

        stack.push(ch);
        return helper(s, idx + 1, stack);
    }
}
