package codingChallenges;

import java.util.Scanner;

// How many characters to remove to get an anagram
// input: "cde" "abc"
// output: 4
/*                   diff
    c: 1   a: 1      c: 0
    d: 1   b: 1  ->  d: 1
    e: 1   c: 1      e: 1
                     a: 1
                     b: 1
                    total: 4
 */

public class makingAnagrams {

    public static int getDelta(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return -1;
        }

        int delta = 0;

        for (int i = 0; i < array1.length; i++) {
            int difference = Math.abs(array1[i] - array2[i]);
            delta += difference;
        }

        return delta;
    }

    public static int[] getCharCounts(String s) {
        // make array of size 26 since the input is
        // always lowercase english alphabet
        int[] charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int offset = (int) 'a';
            int code = c - offset;
            charCounts[code]++;
        }

        return charCounts;
    }

    public static int numberNeeded(String first, String second) {
        int[] charCount1 = getCharCounts(first);
        int[] charCount2 = getCharCounts(second);

        return getDelta(charCount1, charCount2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = "cde"; // in.next();
        String b = "abc"; // in.next();
        System.out.println(numberNeeded(a, b));
    }
}
