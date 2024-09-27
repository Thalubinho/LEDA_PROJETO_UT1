package algorithms;

public class SelectionSort {
	private static void selectionSort(int[] array) {
		int minor, minorIndex;
		for(int unsortedIndex = 0; unsortedIndex < array.length - 1; unsortedIndex++) {
			minor = array[unsortedIndex];
			minorIndex = unsortedIndex;
			for(int index = unsortedIndex; index < array.length; index++) {
				if(array[index] < minor) {
					minor = array[index];
					minorIndex = index;
				}				
			}			
			array[minorIndex] = array[unsortedIndex];
			array[unsortedIndex] = minor;		
		}
	}
}
