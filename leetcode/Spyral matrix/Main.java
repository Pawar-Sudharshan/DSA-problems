import java.util.*;

public class Main {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {

            // 1️⃣ Left → Right (Top row)
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            top++;

            // 2️⃣ Top → Bottom (Right column)
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // 3️⃣ Right → Left (Bottom row)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // 4️⃣ Bottom → Top (Left column)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }

    // -------- MAIN FUNCTION --------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input matrix size
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        // Input matrix elements
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Get spiral order
        List<Integer> result = spiralOrder(matrix);

        // Output
        for (int x : result) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}
