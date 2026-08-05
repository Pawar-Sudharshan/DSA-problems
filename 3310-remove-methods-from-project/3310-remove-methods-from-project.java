import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        boolean[] suspicious = new boolean[n];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : invocations) {
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        suspicious[k] = true;

        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (int x : graph.get(u)) {
                if (!suspicious[x]) {
                    suspicious[x] = true;
                    stack.push(x);
                }
            }
        }

        // Check if any non-suspicious node points to a suspicious node
        for (int[] e : invocations) {
            int a = e[0], b = e[1];
            if (!suspicious[a] && suspicious[b]) {
                List<Integer> all = new ArrayList<>();
                for (int i = 0; i < n; i++) all.add(i);
                return all;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) ans.add(i);
        }
        return ans;
    }
}