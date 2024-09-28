package algorithms;

public class MergeSortIntArray {
    // Merges two subarrays of arr[].
    // First subarray is arr[leftIndex..middleIndex]
    // Second subarray is arr[middleIndex+1..rightIndex]
    private static void merge(int[] arr, int leftIndex, int middleIndex, int rightIndex)
    {
        // Find sizes of two subarrays to be merged
        int sizeLeftArray = middleIndex - leftIndex + 1;
        int sizeRightArray = rightIndex - middleIndex;

        // Create temp arrays
        int[] leftArray = new int[sizeLeftArray];
        int[] rightArray = new int[sizeRightArray];

        // Copy data to temp arrays
        for (int i = 0; i < sizeLeftArray; ++i)
            leftArray[i] = arr[leftIndex + i];
        for (int j = 0; j < sizeRightArray; ++j)
            rightArray[j] = arr[middleIndex + 1 + j];

        // Merge the temp arrays
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = leftIndex;
        while (i < sizeLeftArray && j < sizeRightArray) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            }
            else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < sizeLeftArray) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < sizeRightArray) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(int[] arr, int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // A utility function to print array of size n
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        printArray(arr);

        // Calling of Merge Sort
        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
