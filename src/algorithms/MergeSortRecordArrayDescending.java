package algorithms;

import csv_io.RecordsCSV;
import org.apache.commons.csv.CSVRecord;

public class MergeSortRecordArrayDescending {
    // Merges two sub arrays of arr[].
    // First subarray is arr[leftIndex..middleIndex]
    // Second subarray is arr[middleIndex+1..rightIndex]
    private static void merge(CSVRecord[] arr, int leftIndex, int middleIndex, int rightIndex)
    {
        // Find sizes of two sub arrays to be merged
        int sizeLeftArray = middleIndex - leftIndex + 1;
        int sizeRightArray = rightIndex - middleIndex;

        // Create temp arrays
        CSVRecord[] leftArray = new CSVRecord[sizeLeftArray];
        CSVRecord[] rightArray = new CSVRecord[sizeRightArray];

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
            if (RecordsCSV.compareReleaseDate(leftArray[i].get(2),rightArray[j].get(2))) { // esquerda é menor ou igual ao da direita?
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
    public static void sort(CSVRecord[] arr, int l, int r)
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

    // Driver method
    public static void main(String[] args)
    {

    }
}
