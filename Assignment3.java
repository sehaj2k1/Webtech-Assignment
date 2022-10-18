import java.io.*;
import java.lang.*;
import java.util.*;

class Assignment3 {

    public static void out(Object o) {
        System.out.println(o);
    }

    public static void q1() {
        Scanner s = new Scanner(System.in);
        out("Enter 2 strings for lexiographical comparison:");
        String str1 = s.nextLine();
        String str2 = s.nextLine();
        out("Lexiographical edit distance for the strings:");
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if ((int) str1.charAt(i) == (int) str2.charAt(i)) {
                continue;
            } else {
                out((int) str1.charAt(i) - (int) str2.charAt(i));
                return;
            }
        }

        // Edge case for strings like
        // String 1="Geeky" and String 2="Geekyguy"
        if (str1.length() < str2.length()) {
            out(str1.length() - str2.length());
            return;
        } else if (str1.length() > str2.length()) {
            out(str1.length() - str2.length());
            return;
        }

        // If none of the above conditions is true,
        // it implies both the strings are equal
        else {
            out(0);
            return;
        }
    }

    public static void q2() {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int n = arr.length;

        // The output character array that will have sorted arr
        int output[] = new int[n];

        // Create a count array to store count of individual
        // characters and initialize count array as 0
        int count[] = new int[256];
        for (int i = 0; i < 256; ++i)
            count[i] = 0;

        // store count of each character
        for (int i = 0; i < n; ++i)
            ++count[arr[i]];

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i <= 255; ++i)
            count[i] += count[i - 1];

        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];

        for (int a : arr)
            out(a + " ");
    }

    public static void q3() {
        Scanner s = new Scanner(System.in);
        out("Enter a string to sort: ")
        String s1 = s.nextLine();

        char tempArray[] = s1.toCharArray();

        // Sorting temp array using
        Arrays.sort(tempArray);

        // Returning new sorted string
        s1 = new String(tempArray);
        out(s1);
    }

    public static void q4() {
        // Hailstone sequence

        Scanner s = new Scanner(System.in);
        out("Enter a positive number:");
        int n = s.nextInt();
        out("Hailstone sequence for " + n + ": ");
        out(n);
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
                out(n);
            } else {
                n *= 3;
                n++;
                out(n);
            }
        }
    }

    /* Question 5 - Assignment 3: DP Approach */

    static int dp[][];

    // create List of lists that will store all sets of operations
    static ArrayList<ArrayList<String>> arrs = new ArrayList<ArrayList<String>>();

    // Function to print all ways
    static void printAllChanges(String s1,
            String s2, ArrayList<String> changes) {

        int i = s1.length();
        int j = s2.length();

        // Iterate till end
        while (true) {

            if (i == 0 || j == 0) {

                // Add this list to our List of lists.
                arrs.add(changes);
                break;
            }

            // If same
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                i--;
                j--;
            }

            else {
                boolean if1 = false, if2 = false;

                // Replace
                if (dp[i][j] == dp[i - 1][j - 1] + 1) {

                    // Add this step
                    changes.add("Change " + s1.charAt(i - 1)
                            + " to " + s2.charAt(j - 1));
                    i--;
                    j--;

                    // note whether this 'if' was true.
                    if1 = true;
                }

                // Delete
                if (dp[i][j] == dp[i - 1][j] + 1) {
                    if (if1 == false) {
                        changes.add("Delete " + s1.charAt(i - 1));
                        i--;
                    } else {
                        // If the previous method was true,
                        // create a new list as a copy of previous.
                        ArrayList<String> changes2 = new ArrayList<String>();
                        changes2.addAll(changes);

                        // Remove last operation
                        changes2.remove(changes.size() - 1);

                        // Add this new operation
                        changes2.add("Delete " + s1.charAt(i));

                        // initiate new new instance of this
                        // function with remaining substrings
                        printAllChanges(s1.substring(0, i),
                                s2.substring(0, j + 1), changes2);
                    }

                    if2 = true;
                }

                // Add character step
                if (dp[i][j] == dp[i][j - 1] + 1) {
                    if (if1 == false && if2 == false) {
                        changes.add("Add " + s2.charAt(j - 1));
                        j--;
                    } else {

                        // Add steps
                        ArrayList<String> changes2 = new ArrayList<String>();
                        changes2.addAll(changes);
                        changes2.remove(changes.size() - 1);
                        changes2.add("Add " + s2.charAt(j));

                        // Recursively call for the next steps
                        printAllChanges(s1.substring(0, i + 1),
                                s2.substring(0, j), changes2);
                    }
                }
            }
        }
    }

    // Function to compute the DP matrix
    static void editDP(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] DP = new int[l1 + 1][l2 + 1];

        // initialize by the maximum edits possible
        for (int i = 0; i <= l1; i++)
            DP[i][0] = i;
        for (int j = 0; j <= l2; j++)
            DP[0][j] = j;

        // Compute the DP matrix
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {

                // if the characters are same
                // no changes required
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    DP[i][j] = DP[i - 1][j - 1];
                else {

                    // minimum of three operations possible
                    DP[i][j] = min(DP[i - 1][j - 1],
                            DP[i - 1][j], DP[i][j - 1])
                            + 1;
                }
            }
        }

        // initialize to global array
        dp = DP;
    }

    // Function to find the minimum of three
    static int min(int a, int b, int c) {
        int z = Math.min(a, b);
        return Math.min(z, c);
    }

    static void printWays(String s1, String s2, ArrayList<String> changes) {

        // Function to print all the ways
        printAllChanges(s1, s2, new ArrayList<String>());

        int i = 1;

        // print all the possible ways
        for (ArrayList<String> ar : arrs) {
            System.out.println("\nMethod " + i++ + " : \n");
            for (String s : ar) {
                System.out.println(s);
            }
        }
    }

    // Driver function for the Question-5.
    public static void q5() {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String s2 = s.nextLine();

        // calculate the DP matrix
        editDP(s1, s2);

        // Function to print all ways
        printWays(s1, s2, new ArrayList<String>());
    }

    public static void main(String args[]) {
        System.out.print("Enter corresponding question number for the function to run:");
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        switch (k) {
            case 1:
                q1();
                break;
            case 2:
                q2();
                break;
            case 3:
                q3();
                break;
            case 4:
                q4();
                break;
            case 5:
                q5();
                break;
        }
    }
}
