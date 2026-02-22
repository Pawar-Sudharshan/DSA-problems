import java.util.*;

class Router {
    static class Node {
        int s, d, t;
        Node(int s, int d, int t) {
            this.s = s;
            this.d = d;
            this.t = t;
        }
    }

    private final Deque<Node> q;
    private final int limit;
    private final Set<String> seen;
    // Changed to ArrayList for O(log N) binary search capability
    private final Map<Integer, List<Integer>> map;

    public Router(int memoryLimit) {
        q = new ArrayDeque<>();
        limit = memoryLimit;
        seen = new HashSet<>();
        map = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (seen.contains(key)) return false;

        // If at capacity, remove the oldest packet (FIFO)
        if (q.size() == limit) {
            removeOldest();
        }

        Node node = new Node(source, destination, timestamp);
        q.offerLast(node);
        seen.add(key);

        map.putIfAbsent(destination, new ArrayList<>());
        map.get(destination).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if (q.isEmpty()) return new int[0];

        Node x = q.peekFirst();
        int[] result = new int[]{x.s, x.d, x.t};
        removeOldest();
        
        return result;
    }

    private void removeOldest() {
        Node old = q.pollFirst();
        seen.remove(old.s + "#" + old.d + "#" + old.t);

        List<Integer> list = map.get(old.d);
        // Removing from the start of an ArrayList is O(N). 
        // For absolute optimization, use a pointer or a balanced BST, 
        // but for most constraints, this is the standard approach.
        if (list != null && !list.isEmpty()) {
            list.remove(0); 
            if (list.isEmpty()) map.remove(old.d);
        }
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!map.containsKey(destination)) return 0;

        List<Integer> timestamps = map.get(destination);
        
        // Find first index >= startTime
        int startIdx = lowerBound(timestamps, startTime);
        // Find last index <= endTime
        int endIdx = upperBound(timestamps, endTime);

        if (startIdx > endIdx) return 0;
        return endIdx - startIdx + 1;
    }

    // Standard binary search for first element >= target
    private int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size() - 1;
        int ans = list.size();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Standard binary search for last element <= target
    private int upperBound(List<Integer> list, int target) {
        int low = 0, high = list.size() - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}