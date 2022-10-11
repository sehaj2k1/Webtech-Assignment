import java.io.*;
import java.lang.*;
import java.util.*;

class Assignment3 {

    public static void out(Object o) {
        System.out.println(o);
    }

    public static void q1() {
        Scanner s = new Scanner(System.in);
        out("Enter first string:");
        String s1 = s.nextLine();
        out("Enter second string:");
        String s2 = s.nextLine();
        if (s1 < s2)
            out(s1 + " is lexiographically smaller than " + s2);
        else if (s1 > s2)
            out(s1 + " is lexiographically greater than " + s2);
        else
            out(s1 + " is lexiographically equal to " + s2);
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
        String s1 = s.nextLine();

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
            // case 4:
            // q4();
            // break;
            // case 5:
            // q5();
            // break;
        }
    }
}
