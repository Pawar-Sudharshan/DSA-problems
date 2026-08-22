import java.util.*;

class KthLargest {
    private int k;
    private PriorityQueue<Integer> q;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.q = new PriorityQueue<>();

        for (int value : nums) {
            q.offer(value);
        }
        int  t  = k;
        while (q.size() > k) {
           q.poll();
            // t--;
        }

        // Collections.sort(list, Collections.reverseOrder());
    }

    public int add(int val) {
        q.offer(val);

        // List<Integer> list = new ArrayList<>();
        // int t = k;

       while (q.size() > k) {
            q.poll();
            // t--;
        }

        // int x = list.get(k - 1);

        // while (!list.isEmpty()) {
        //     q.offer(list.remove(list.size() - 1));
        // }

        return q.peek();
    }
}