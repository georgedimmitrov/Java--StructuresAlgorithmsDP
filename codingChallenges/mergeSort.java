package codingChallenges;

public class mergeSort {
    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
//        int[] intArray = { 1, 2, 3, 4, 20 };
//        int[] intArray = { 1, 22, 3, 4, 20 };

//        mergeSort(intArray);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        // base case - when array has only one element
        if (end - start < 2) {
            return;
        }

        // partition passed-in array
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        // if last element in left partition is less than or equal to first element in right partition
        // -> all elements are sorted correctly
        if (arr[mid - 1] <= arr[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            temp[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
    }
}
