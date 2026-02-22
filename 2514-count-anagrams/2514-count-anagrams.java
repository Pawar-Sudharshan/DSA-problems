import java.util.*;

class Solution {
    long mod = 1_000_000_007;

    public int countAnagrams(String s) {
        int n = s.length();
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }

        long totalWays = 1;
        String[] words = s.split(" ");

        for (String word : words) {
            totalWays = (totalWays * countWordAnagrams(word, fact)) % mod;
        }

        return (int) totalWays;
    }

    private long countWordAnagrams(String word, long[] fact) {
        int n = word.length();
        int[] counts = new int[26];
        for (char c : word.toCharArray()) {
            counts[c - 'a']++;
        }

        // Numerator: n!
        long numerator = fact[n];

        // Denominator: (c1! * c2! * ... * ck!)
        long denominator = 1;
        for (int count : counts) {
            if (count > 1) {
                denominator = (denominator * fact[count]) % mod;
            }
        }

        // Result = numerator * modInverse(denominator)
        return (numerator * power(denominator, mod - 2)) % mod;
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}