package algorithms;

import csv_io.RecordsCSV;
import org.apache.commons.csv.CSVRecord;

public class QuickSort {

    public static void quickSort(CSVRecord[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivoIndice = particaoHaore(vetor, inicio, fim);
            quickSort(vetor, inicio, pivoIndice - 1);       // Ordena a sublista à esquerda do pivô
            quickSort(vetor, pivoIndice + 1, fim);    // Ordena a sublista à direita do pivô
        }
    }

    private static int particaoHaore(CSVRecord[] vetor, int esquerda, int direita) {
        int meio = (esquerda + direita) / 2;
        CSVRecord pivo = vetor[meio];
        int pivoIndice = meio;
        int i = esquerda - 1;
        int j = direita  + 1;

        while (i < j) {
            do{
                i++;
            }while (!(RecordsCSV.compareReleaseDate(vetor[i].get(2), pivo.get(2))));

            do{
                j--;
            }while (RecordsCSV.compareReleaseDate(vetor[j].get(2), pivo.get(2)));

            // Troca os elementos
            if(!(i >= j)){
                CSVRecord aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
            }

        }

        //Procurando o indice do pivo
        int k = 0;
        do {
            if(RecordsCSV.equals(vetor[k].get(2), pivo.get(2))){
                pivoIndice = k;
            }
        } while (!(RecordsCSV.equals(vetor[k].get(2), pivo.get(2))));

        return pivoIndice;
    }
}
