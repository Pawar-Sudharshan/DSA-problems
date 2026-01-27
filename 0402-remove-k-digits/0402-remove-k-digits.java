import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        // If we remove all digits, answer is "0"
        if (k == n) return "0";

        Deque<Character> stack = new ArrayDeque<>();

        for (char digit : num.toCharArray()) {
            // Remove larger previous digits while we can
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > digit) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(digit);
        }

        // If k is still > 0, remove from the end (largest suffix)
        while (k > 0 && !stack.isEmpty()) {
            stack.pollLast();
            k--;
        }

        // Build result and remove leading zeros
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while (!stack.isEmpty()) {
            char c = stack.pollFirst();
            if (leadingZero && c == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(c);
        }

        // If everything was removed or only zeros, return "0"
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}
