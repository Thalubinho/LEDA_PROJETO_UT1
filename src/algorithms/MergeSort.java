package algorithms;

public class MergeSort {

    public static void merge(long array[]){
        if (array.length > 1){
            int meio = array.length / 2;
            long arrayEsquerda[] = new long[meio];
            long arrayDireita[] = new long[array.length - meio];

            //preenchendo o array
            for (int i = 0; i < meio; i++){
                arrayEsquerda[i] = array[i];
            }
            for (int j = meio; j < array.length; j++){
                arrayDireita[j - meio] = array[j];
            }

            merge(arrayEsquerda);
            merge(arrayDireita);
            sort(array, arrayEsquerda, arrayDireita);
        }
    }

    public static void sort(long array[], long esquerda[], long direita[]){
        int tamEsquerda = esquerda.length;
        int tamDireita = direita.length;

        int i = 0, j = 0, k = 0;
        while (i < tamEsquerda && j < tamDireita){
            if (esquerda[i] < direita[j]){
                array[k] = esquerda[i];
                i++;
            } else {
                array[k] = direita[j];
                j++;
            }
            k++;
        }
        //adicionando o restante dos elementos
        while(i < tamEsquerda){
            array[k] = esquerda[i];
            i++;
            k++;
        }
        while(j < tamDireita){
            array[k] = direita[j];
            j++;
            k++;
        }
    }
}