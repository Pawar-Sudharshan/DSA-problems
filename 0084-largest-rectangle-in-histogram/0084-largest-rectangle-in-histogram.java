import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = prevSmaller(heights);
        int[] right = nextSmaller(heights);

        long maxArea = 0;

        for (int i = 0; i < n; i++) {
            long width = right[i] - left[i] - 1;     // total width where heights[i] is min
            long area = (long) heights[i] * width;
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return (int) maxArea;
    }

    // previous strictly smaller element index for each i
    private int[] prevSmaller(int[] h) {
        int n = h.length;
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && h[st.peek()] >= h[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                prev[i] = st.peek();
            }
            st.push(i);
        }
        return prev;
    }

    // next strictly smaller element index for each i
    private int[] nextSmaller(int[] h) {
        int n = h.length;
        int[] next = new int[n];
        Arrays.fill(next, n);
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && h[st.peek()] >= h[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                next[i] = st.peek();
            }
            st.push(i);
        }
        return next;
    }
}
