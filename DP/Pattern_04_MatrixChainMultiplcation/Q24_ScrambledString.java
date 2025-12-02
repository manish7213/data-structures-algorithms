package DP.Pattern_04_MatrixChainMultiplcation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=VyHEglhbm-A&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=41">YouTube: ScrambledString</a>
 * <p>
 * <a href="https://leetcode.com/problems/scramble-string/">LC: MatrixChainMultiplication</a>
 * <p>
 * <p>
 */
public class Q24_ScrambledString {
    private final Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {

        // Fast reject
        if (s1.length() != s2.length())
            return false;

        // Key for memoization
        String key = s1 + "#" + s2;
        if (memo.containsKey(key))
            return memo.get(key);

        // Base case
        if (s1.equals(s2)) {
            memo.put(key, true);
            return true;
        }

        // Prune using character counts
        if (!haveSameChars(s1, s2)) {
            memo.put(key, false);
            return false;
        }

        int n = s1.length();

        // Try all possible partitions
        for (int i = 1; i < n; i++) {

            // Case 1: No swap
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }

            // Case 2: Swap
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    private boolean haveSameChars(String s1, String s2) {
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int c : count)
            if (c != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Q24_ScrambledString sol = new Q24_ScrambledString();

        System.out.println("Test 1: " + sol.isScramble("great", "rgeat"));
        // expected: true

        System.out.println("Test 2: " + sol.isScramble("abc", "caa"));
        // expected: false

        System.out.println("Test 3: " + sol.isScramble("abcde", "caebd"));
        // expected: false

        System.out.println("Test 4: " + sol.isScramble("abcde", "edcba"));
        // expected: true

        System.out.println("Test 5: " + sol.isScramble("aaaa", "aaaa"));
        // expected: true

        System.out.println("Test 6: " + sol.isScramble("great", "egtra"));
        // expected: false
    }
}
