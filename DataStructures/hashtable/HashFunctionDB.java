package DataStructures.hashtable;

// If we think of a Hash Table as an array
// then a hash function is used to generate
// a unique key for every item in the array.
// The position the item goes in is known
// as the slot. Hashing doesn't work very well
// in situations in which duplicate data
// is stored. Also it isn't good for searching
// for anything except a specific key.
// However a Hash Table is a data structure that
// offers fast insertion and searching capabilities.

import java.util.Arrays;

public class HashFunctionDB {
    String[] theArray;
    int arraySize;
    int itemsInArray = 0;

    public static void main(String[] args) {

    }

    HashFunctionDB(int size) {
        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray, "-1");
    }

    public void displayTheStack() {
        int increment = 0;

        for (int m = 0; m < 3; m++) {
            increment += 10;

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {
                System.out.format("| %3s " + " ", n);
            }

            System.out.println("|");

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {
                if (theArray[n].equals("-1"))
                    System.out.print("|      ");
                else
                    System.out
                            .print(String.format("| %3s " + " ", theArray[n]));
            }

            System.out.println("|");

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();
        }
    }
}
