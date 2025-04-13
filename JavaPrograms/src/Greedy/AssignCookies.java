package Greedy;

import java.util.Arrays;

public class AssignCookies {

    public static void main(String[] args) {
        AssignCookies assignCookies = new AssignCookies();

        // Test case 1
        int[] g1 = {1, 2, 3};
        int[] s1 = {1, 1};
        System.out.println(assignCookies.findContentChildren(g1, s1)); // Output: 1

        // Test case 2
        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};
        System.out.println(assignCookies.findContentChildren(g2, s2)); // Output: 2
    }

    public int findContentChildren(int[] g, int[] s) {
        // Sort greed factors and cookie sizes
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // Pointer for children
        int j = 0; // Pointer for cookies
        int contentChildren = 0;

        // Try to assign cookies
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                // Cookie s[j] can satisfy child g[i]
                contentChildren++;
                i++; // Move to next child
            }
            // Whether the cookie satisfies the child or not, move to the next cookie
            j++;
        }

        return contentChildren;
    }


}
