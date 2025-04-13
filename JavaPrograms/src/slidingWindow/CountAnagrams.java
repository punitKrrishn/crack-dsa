package slidingWindow;

import java.util.HashMap;

public class CountAnagrams {
    public static void main(String[] args) {
        String str = "aabaabaa";
        String sub = "aaba";
        int ans = countAnagrams(str, sub);
        System.out.println(ans); // Output should be 4
    }

    public static int countAnagrams(String a, String b) {
        // Step 1: Initialize a hash map for the pattern (string b)
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i = 0;  // Start of the sliding window
        int j = 0;  // End of the sliding window
        int count = map.size();  // Track how many unique characters we need to match
        int ans = 0;  // The number of anagram matches
        int k = b.length();  // The length of the pattern string b

        while (j < a.length()) {
            // Step 2: Process the character at a[j] (add it to the window)
            char currentChar = a.charAt(j);
            if (map.containsKey(currentChar)) {
                map.put(currentChar, map.get(currentChar) - 1);
                if (map.get(currentChar) == 0) {
                    count--;  // Decrease the count of unmatched characters
                }
            }

            // Step 3: If the window size is smaller than the pattern, expand the window
            if (j - i + 1 < k) {
                j++;
            }
            // Step 4: If the window size is equal to the pattern size, check for matches
            else if (j - i + 1 == k) {
                if (count == 0) {  // All characters are matched
                    ans++;
                }

                // Step 5: Slide the window by incrementing i and adjusting the map
                if (map.containsKey(a.charAt(i)) && map.get(a.charAt(i)) == 0) {
                    map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
                    count++;
                } else if (map.containsKey(a.charAt(i))) {
                    map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
                }

                // Move the start of the window
                i++;
                // Move the end of the window
                j++;
            }
        }

        return ans;  // Return the total count of anagram matches
    }
}
