package BackTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class StringPermutations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Write some name : ");
        String input = sc.nextLine();
        System.out.println("All Permutations are :- ");
        ArrayList<String> ds = new ArrayList<>();
        printPermutations(input, "", ds);  // Start recursion with an empty string
        // Print out all permutations
        for (String permutation : ds) {
            System.out.println(permutation);
        }
    }

    // Recursive function to generate permutations
    private static void printPermutations(String input, String current, ArrayList<String> ds) {
        if (input.isEmpty()) {
            ds.add(current);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            String remaining = input.substring(0, i) + input.substring(i + 1);
            printPermutations(remaining, current + ch, ds);
        }
    }
}
