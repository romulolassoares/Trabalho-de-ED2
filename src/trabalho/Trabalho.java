/**
 * @author romulo
 */
package trabalho;

import java.io.IOException;
import java.util.Scanner;
import ordenacao.InsertionSort;
import ordenacao.MergeSort;
import ordenacao.QuickSort;

public class Trabalho {
    public static void main(String[] args) throws IOException {
        int option;
        Scanner input = new Scanner(System.in);
        Registro[] vetor; //Inicia um vetor de Musica para armazernar os dados do arquivo .csv
        Leitura a = new Leitura(); //Inicializa a classe para executar a leitura do arquivo .csv
        InsertionSort insertion;
        MergeSort merge;
        QuickSort quick;
        vetor = a.lerArquivo(); //Lê o arquivo .csv e passa para o vetor os dados
        //Menu para selecionar o método de ordenção
        System.out.println("Escolha como orgazinar");
        System.out.println("(1) Insertion Sort");
        System.out.println("(2) Merge Sort");
        System.out.println("(3) Quick Sort");
        option = input.nextInt();
        switch(option){
            case 1: insertion = new InsertionSort(vetor, vetor.length);
                    insertion.organiza();
                    break;
            case 2: merge = new MergeSort(vetor);
                    merge.organiza();
                    break;
            case 3: quick = new QuickSort(vetor);
                    quick.organiza();
                    break;
        }
        //Final do menu
        //Impressão dos dados após a organização
        for (int i = 0; i < vetor.length; i++) {
            vetor[i].imprimir();
        }
        
    }  
}
