import java.util.*;

public class Main {

    // LeetCode-style solution method
    public static int minDeletionSize(String[] strs) {
        int n = strs.length;          // number of rows
        int m = strs[0].length();     // number of columns
        int deleteCount = 0;

        // Check each column
        for (int col = 0; col < m; col++) {
            for (int row = 1; row < n; row++) {
                // If current character is smaller than the one above
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    deleteCount++;   // this column must be deleted
                    break;           // move to next column
                }
            }
        }

        return deleteCount;
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of strings
        int n = sc.nextInt();
        String[] strs = new String[n];

        // Read strings
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }

        // Print result
        System.out.println(minDeletionSize(strs));

        sc.close();
    }
}
