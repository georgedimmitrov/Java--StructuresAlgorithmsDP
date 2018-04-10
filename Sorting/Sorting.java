package Sorting;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class Sorting {
    public static int[] selectionSort(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            // i points at first number behind "wall"
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

    // this function can be used for "mergeSort call" where you only pass array
    // it generates "from" and "to" parameters
    public static void mergeSortExecutor(int[] input) {
        mergeSort(input, 0, input.length - 1);
    }

    public static void mergeSort(int[] input, int from, int to) {
        if (from < to) {
            int middle = (from + to) / 2;
            mergeSort(input, from, middle);
            mergeSort(input, middle + 1, to);
            merge(input, from, middle, to);
        }
    }

    public static void merge(int[] input, int from, int middle, int to) {
        int lengthLeft = middle - from + 1;
        int lengthRight = to - middle;
        int[] left = new int[lengthLeft + 1];
        int[] right = new int[lengthRight + 1];

        for (int i = 0; i < lengthLeft; i++) {
            left[i] = input[from + i];
        }

        for (int i = 0; i < lengthRight; i++) {
            right[i] = input[middle + i + 1];
        }

        left[lengthLeft] = Integer.MAX_VALUE;
        right[lengthRight] = Integer.MAX_VALUE;

        int leftPointer = 0;
        int rightPointer = 0;

        for (int i = from; i <= to; i++) {
            if (left[leftPointer] > right[rightPointer]) {
                input[i] = right[rightPointer];
                rightPointer++;
            } else {
                input[i] = left[leftPointer];
                leftPointer++;
            }
        }
    }



    // this function can be used for "quickSort call" where you only pass array
    // it generates "from" and "to" parameters
    public static void quickSortExecutor(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    public static void quickSort(int[] input, int from, int to) {
        if (from < to) {
            int indexOfPivot = partition(input, from, to);
            quickSort(input, from, indexOfPivot - 1);
            quickSort(input, indexOfPivot + 1, to);
        }
    }

    public static int partition(int[] input, int from, int to) {
        int pivot = input[to];
        int wall = from;

        for (int i = from; i < to; i++) {
            if (input[i] <= pivot) {
                int temp = input[wall];
                input[wall] = input[i];
                input[i] = temp;
                wall++;
            }
        }

        input[to] = input[wall];
        input[wall] = pivot;

        return wall;
    }

    // this function can be used for "quickSortAverage call" where you only pass array
    // it generates "from" and "to" parameters
    public static void quickSortMedianExecutor(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    public static void quickSortMedian(int[] input, int from, int to) {
        if (from < to) {
            int indexOfPivot = partitionMedian(input, from, to);
            quickSort(input, from, indexOfPivot - 1);
            quickSort(input, indexOfPivot + 1, to);
        }
    }

    public static int medianOfThree(int[] input, int first, int middle, int last) {
        int[] array = {input[first], input[middle], input[last]};
        selectionSort(array);
        if (array[1] == input[first]) {
            return first;
        } else if (array[1] == input[middle]) {
            return middle;
        } else {
            return last;
        }
    }

    public static int partitionMedian(int[] input, int from, int to) {
        int indexOfPivot = medianOfThree(input, from, (from + to) / 2, to);
        int pivot = input[indexOfPivot];
        if (indexOfPivot != to) {
            input[indexOfPivot] = input[to];
            //input[to] = pivot;
        }
        int wall = from;
        for (int i = from; i < to; i++) {
            if (input[i] <= pivot) {
                int temp = input[wall];
                input[wall] = input[i];
                input[i] = temp;
                wall++;
            }
        }
        input[to] = input[wall];
        input[wall] = pivot;

        return wall;
    }


    public static int[] generateArray(int size, int from, int to) {
        Random randomGenerator = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomGenerator.nextInt(to) + from;
        }
        return result;
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSortedDecreasing(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int sizeOfInput = 1000;
        int numberOfArrays = 1000;
        String[] algorithms = {"selectionSort", "bubbleSort", "mergeSortExecutor", "quickSortExecutor", "quickSortMedianExecutor"};

        for (String algorithm : algorithms) {

            Method m = Sorting.class.getMethod(algorithm, int[].class);

            System.out.println("Testing : " + algorithm);
            long startTime = System.nanoTime();
            for (int i = 0; i < numberOfArrays; i++) {
                int[] testArray = generateArray(sizeOfInput, 0, 100);
                int[] cloneArray = testArray.clone();
                // just in case algorithms is not sorting correctly
                m.invoke(Sorting.class, testArray);
                if (!isSorted(testArray)) {
                    printArray(cloneArray);
                    System.out.println("Error: Unsorted Array");
                    printArray(testArray);
                }
            }
            long endTime = System.nanoTime();

            System.out.println("*********************");
            System.out.println("Finished " + numberOfArrays + " tests.");
            System.out.println("Took " + (endTime - startTime) / 1000000000.0 + " s");
            System.out.println("*********************");
            System.out.println();
        }

    }
}
