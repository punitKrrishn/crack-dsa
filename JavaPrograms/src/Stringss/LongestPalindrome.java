package Stringss;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "aAAbbA";
        ArrayList<Character> ans = findLongestPalindrome(s);

        // Print the result (convert ArrayList to string to display the palindrome)
        StringBuilder sb = new StringBuilder();
        for (char c : ans) {
            sb.append(c);
        }
        System.out.println("Longest Palindromic Subsequence: " + sb.toString());
    }

    private static ArrayList<Character> findLongestPalindrome(String s) {
        // HashMap to store frequency of each character
        HashMap<Character, Integer> map = new HashMap<>();

        // Count the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // ArrayList to store the result
        ArrayList<Character> firstHalf = new ArrayList<>();
        Character middleChar = null;

        // Create the first half of the palindrome and check for a middle character
        for (char c : map.keySet()) {
            int count = map.get(c);

            if (count % 2 == 0) {
                // For even frequency, add half of the characters to the first half
                for (int i = 0; i < count / 2; i++) {
                    firstHalf.add(c);
                }
            } else {
                // For odd frequency, add half of the characters to the first half
                for (int i = 0; i < count / 2; i++) {
                    firstHalf.add(c);
                }
                // If no middle character has been set yet, set this as the middle character
                if (middleChar == null) {
                    middleChar = c;
                }
            }
        }

        // Create the second half by reversing the first half
        ArrayList<Character> secondHalf = new ArrayList<>(firstHalf);
        java.util.Collections.reverse(secondHalf);

        // If there is a middle character, place it in the middle
        ArrayList<Character> result = new ArrayList<>();
        result.addAll(firstHalf);

        if (middleChar != null) {
            result.add(middleChar);
        }

        result.addAll(secondHalf);

        return result;
    }
}
