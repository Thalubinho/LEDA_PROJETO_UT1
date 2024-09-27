package algorithms;

public class InsertionSort {
	
	private static void insertionSort(int[] array){
		
	      for(int indexUnsorted = 1; indexUnsorted < array.length; indexUnsorted++){ //Considera o primeiro elemento como ordenado
	        int indexSorted = indexUnsorted - 1;
	        int unsortedElement = array[indexUnsorted];
	        int sortedElement = array[indexSorted]; 
	        while(indexSorted >= 0 && array[indexSorted] > unsortedElement){ 
	            array[indexSorted+1] = array[indexSorted];
	            array[indexSorted] = unsortedElement;
	            indexSorted--;
	            System.out.println();
	        }
	        System.out.println();
	      }
	  }
}
