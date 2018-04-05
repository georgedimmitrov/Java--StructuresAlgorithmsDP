package Sorting;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] sampleArr = {90, 66, 123, 55, 4};
//        selectionSort(sampleArr);
//        bubbleSort(sampleArr);
        System.out.println(Arrays.toString(sampleArr));
    }

    public static int[] selectionSort(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            int indexOfMin = i;

            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[indexOfMin]) {
                    indexOfMin = j;
                }
            }

            if (i != indexOfMin) {
                int lesser = input[indexOfMin];
                input[indexOfMin] = input[i];
                input[i] = lesser;
            }
        }

        return input;
    }

    public static void bubbleSort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            // i represents how many elements have bubbled to correct length

            // optimization if there was no swap
            boolean swapped = false;

            for (int j = 0; j < input.length - 1 - i; j++) {
                if (input[j] > input[j + 1]) {
                    swapped = true;
                    int lesser = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = lesser;
                }
            }

            if (!swapped) {
                return;
            }
        }
    }
}
