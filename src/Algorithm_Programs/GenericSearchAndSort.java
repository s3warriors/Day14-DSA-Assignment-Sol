package Algorithm_Programs;

import java.util.Arrays;

public class GenericSearchAndSort<T extends Comparable<T>> {

    // Generic Binary Search
    public int binarySearch(T[] arr, T key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].compareTo(key) == 0) {
                return mid;
            } else if (arr[mid].compareTo(key) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Element not found
    }

    // Generic Bubble Sort
    public void bubbleSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Swap elements
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Generic Insertion Sort
    public void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;

            // Move elements greater than key to one position ahead
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Generic Merge Sort
    public void mergeSort(T[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively sort the two halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    private void merge(T[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        T[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        T[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        // Merge the arrays back into arr
        while (i < n1 && j < n2) {
            if (leftArr[i].compareTo(rightArr[j]) <= 0) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy remaining elements
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    // Main method to test the algorithms
    public static void main(String[] args) {
        GenericSearchAndSort<Integer> integerSortAndSearch = new GenericSearchAndSort<>();
        Integer[] intArr = {5, 3, 8, 6, 2, 7, 4, 1};
        Integer key = 6;

        System.out.println("Original Array: " + Arrays.toString(intArr));

        // Bubble Sort
        integerSortAndSearch.bubbleSort(intArr);
        System.out.println("Bubble Sorted Array: " + Arrays.toString(intArr));

        // Binary Search
        int result = integerSortAndSearch.binarySearch(intArr, key);
        System.out.println("Binary Search Result for " + key + ": " + (result >= 0 ? "Found at index " + result : "Not Found"));

        // Insertion Sort
        Integer[] insertionSortArr = {5, 3, 8, 6, 2, 7, 4, 1};
        integerSortAndSearch.insertionSort(insertionSortArr);
        System.out.println("Insertion Sorted Array: " + Arrays.toString(insertionSortArr));

        // Merge Sort
        Integer[] mergeSortArr = {5, 3, 8, 6, 2, 7, 4, 1};
        integerSortAndSearch.mergeSort(mergeSortArr, 0, mergeSortArr.length - 1);
        System.out.println("Merge Sorted Array: " + Arrays.toString(mergeSortArr));

        // Generic String Sorting Example
        GenericSearchAndSort<String> stringSortAndSearch = new GenericSearchAndSort<>();
        String[] strArr = {"banana", "apple", "grape", "cherry", "orange"};
        System.out.println("\nOriginal String Array: " + Arrays.toString(strArr));

        // Bubble Sort on Strings
        stringSortAndSearch.bubbleSort(strArr);
        System.out.println("Bubble Sorted String Array: " + Arrays.toString(strArr));

        // Binary Search on Strings
        String searchKey = "grape";
        int stringResult = stringSortAndSearch.binarySearch(strArr, searchKey);
        System.out.println("Binary Search Result for \"" + searchKey + "\": " + (stringResult >= 0 ? "Found at index " + stringResult : "Not Found"));
    }
}


