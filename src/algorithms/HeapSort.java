package algorithms;

import csv_io.RecordsCSV;
import org.apache.commons.csv.CSVRecord;

import java.util.Scanner;

public class HeapSort {

    // Método que implementa o Heapsort
    public static void heapSort(CSVRecord[] array) {
        int tamanho = array.length; // nos da o tamanho do array passado no argumento da funcao
        int i = tamanho / 2, pai, filho; // Inicializa variáveis
        CSVRecord t;

        // Loop principal que continua até que todos os elementos sejam ordenados
        while (true) {
            // Verifica se ainda há nós não folhos no heap
            if (i > 0) {
                i--; // Move para o próximo nó
                t = array[i]; // Armazena o valor do nó atual
            } else {
                // Caso todos os nós tenham sido processados
                tamanho--; // Reduz o tamanho do heap
                if (tamanho <= 0) { return; } // Se o tamanho é zero, termina
                t = array[tamanho]; // Armazena o último elemento
                array[tamanho] = array[0]; // Coloca o maior elemento no final do array
            }

            pai = i; // Inicializa o índice do pai
            filho = (i * 2 + 1); // Calcula o índice do filho esquerdo

            // Loop para restaurar a propriedade do heap
            while (filho < tamanho) {
                // Verifica se o filho à direita existe e se é maior que o filho à esquerda
                if ((filho + 1 < tamanho) &&
                    RecordsCSV.compareReleaseDate(array[filho + 1].get(2), array[filho].get(2))) {

                    filho++; // Move para o filho à direita
                }
                // Se o filho maior é maior que o pai
                if (RecordsCSV.compareReleaseDate(array[filho].get(2), t.get(2))) {
                    array[pai] = array[filho]; // Move o filho para a posição do pai
                    pai = filho; // Atualiza o pai para o filho
                    filho = pai * 2 + 1; // Calcula o novo filho
                } else {
                    break; // Se a propriedade do heap está restaurada, sai do loop
                }
            }
            array[pai] = t; // Coloca o valor armazenado na posição correta
        }
    }
}
