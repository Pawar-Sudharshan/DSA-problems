import java.util.Scanner;

class Solution {

    // Method to calculate number of ways to climb stairs
    public static int climbStairs(int n) {

        // Base cases
        if (n == 1 || n == 2)
            return n;

        // Variables to store previous two results
        int prev2 = 1; // ways to reach step 1
        int prev1 = 2; // ways to reach step 2
        int current = 0;

        // Compute ways from step 3 to n
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    // Main function
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter number of steps: ");
        int n = sc.nextInt();

        // Output
        int result = climbStairs(n);
        System.out.println("Number of ways to climb the stairs: " + result);

        sc.close();
    }
}
