package codingChallenges;

public class SelectionSort {
    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
//        int[] intArray = { 1, 2, 3, 4, 20 };
//        int[] intArray = { 27, 2, 3, 4, 27 };

        selectionSortMin(intArray);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void selectionSort(int[] arr) {
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largestIndex = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (arr[i] > arr[largestIndex]) {
                    largestIndex = i;
                }
            }

            if (largestIndex != lastUnsortedIndex) {
                Utils.swap(arr, largestIndex, lastUnsortedIndex);
            }
        }
    }

    public static void selectionSortMin(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int indexOfMin = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[indexOfMin] > arr[j]) {
                    indexOfMin = j;
                }
            }

            if (indexOfMin != i) {
                Utils.swap(arr, indexOfMin, i);
            }
        }
    }
}
