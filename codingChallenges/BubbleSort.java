package codingChallenges;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
//        int[] intArray = { 1, 2, 3, 4, 20 };
        int[] intArray = { 1, 22, 3, 4, 20 };

        bubbleSort(intArray);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void bubbleSort(int[] intArray) {
        boolean swapped = false;

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    Utils.swap(intArray, i, i + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                return;
            }
        }
    }

    public static void bubbleSortOptimized(int[] intArray) {
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            for (int i = 1; i < intArray.length; i++) {
                if (intArray[i - 1] > intArray[i]) {
                    Utils.swap(intArray, i - 1, i);
                    swapped = true;
                }
            }
        }
    }
}
