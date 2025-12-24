public class Main {

    public static int minimumBoxes(int[] apple, int[] capacity) {
        // Step 1: Calculate total apples
        int totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }

        // Step 2: Sort capacity in descending order
        Arrays.sort(capacity);
        int m = capacity.length;
        for (int i = 0; i < m / 2; i++) {
            int temp = capacity[i];
            capacity[i] = capacity[m - 1 - i];
            capacity[m - 1 - i] = temp;
        }

        // Step 3: Greedily select boxes
        int boxesUsed = 0;
        for (int cap : capacity) {
            totalApples -= cap;
            boxesUsed++;
            if (totalApples <= 0) {
                break;
            }
        }

        return boxesUsed;
    }

    public static void main(String[] args) {
        int[] apple = {1, 3, 2};
        int[] capacity = {4, 3, 1, 5, 2};

        int result = minimumBoxes(apple, capacity);
        System.out.println("Minimum boxes required: " + result);
    }
}
