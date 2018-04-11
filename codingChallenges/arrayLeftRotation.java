package codingChallenges;

import java.util.Scanner;

public class arrayLeftRotation {
    // Input
    // 5 4
    // 1 2 3 4 5

    // Expected Output
    // 5 1 2 3 4
    public static void main(String[] args) {
        // Use scanner to read inputs.
        Scanner in = new Scanner(System.in);

        // Number of elements contained in the array.
        int size = 5; // in.nextInt();

        // Number of left-rotations to perform in the array.
        int rotations = 4; // in.nextInt();

        // The array of size 'size' to perform left-rotations on.
        int arr[] = {1, 2, 3, 4, 5}; //new int[size];

        // Read and store the elements of the array.
//        for (int a_i=0; a_i < size; a_i++) {
//            arr[a_i] = in.nextInt();
//        }

        // solution
        int[] rotated = new int[size];
//        for (int i = 0; i < size; i++) {
//            int index = (i + rotations) % arr.length;
//            rotated[i] = arr[index];
//        }

        for (int i = 0; i < rotations; i++) {
            arr = rotateArr(arr);
        }

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] rotateArr(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;

        return arr;
    }
}
