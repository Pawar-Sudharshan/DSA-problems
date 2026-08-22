import java.util.*;

class MedianFinder {
    private PriorityQueue<Integer> min; // Larger half
    private PriorityQueue<Integer> max; // Smaller half

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        max.offer(num);

        min.offer(max.poll());
        if (min.size() > max.size()) {
            max.offer(min.poll());
        }
    }

    public double findMedian() {
        if (max.size() > min.size()) {
            return max.peek();
        }
        return ((double) max.peek() + min.peek()) / 2.0;
    }
}