class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        boolean[] inStack = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            freq[idx]--; 

            if (inStack[idx]) {
                continue;
            }
            while (!stack.isEmpty()) {
                char top = stack.peekLast();
                int topIdx = top - 'a';
                if (top > c && freq[topIdx] > 0) {
                    stack.pollLast();
                    inStack[topIdx] = false;
                } else {
                    break;
                }
            }

            stack.offerLast(c);
            inStack[idx] = true;
        }

        StringBuilder ans = new StringBuilder();
        for (char c : stack) {
            ans.append(c);
        }
        return ans.toString();
    }
}