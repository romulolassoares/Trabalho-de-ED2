/**
 * @author romulo
 */
package trabalho;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import ordenacao.InsertionSort;
import ordenacao.MergeSort;
import ordenacao.QuickSort;

public class Trabalho {
    public static void main(String[] args) throws IOException {
        int option, quant;
        Scanner input = new Scanner(System.in);
        Registro[] vetor; //Inicia um vetor de Musica para armazernar os dados do arquivo .csv
        //++++++++++++++++++++++++++++++++++++
        System.out.println("Informa a quantidade de valores a serem lidos: ");
        quant = input.nextInt();
        //++++++++++++++++++++++++++++++++++++
        Leitura a = new Leitura(quant); //Inicializa a classe para executar a leitura do arquivo .csv
        vetor = a.lerArquivo(); //Lê o arquivo .csv e passa para o vetor os dados
//        InsertionSort insertion;
//        MergeSort merge;
        QuickSort quick;
        // Menu para selecionar o método de ordenção
//        System.out.println("Escolha como orgazinar");
//        System.out.println("(1) Insertion Sort");
//        System.out.println("(2) Merge Sort");
//        System.out.println("(3) Quick Sort");
//        option = input.nextInt();
//        switch(option){
//            case 1: insertion = new InsertionSort(vetor, vetor.length);
//                    insertion.organiza();
//                    break;
//            case 2: merge = new MergeSort(vetor);
//                    merge.organiza();
//                    break;
//            case 3: quick = new QuickSort(vetor);
//                    quick.organiza();
//                    break;
//        }
        //Final do menu
        //Impressão dos dados após a organização
        quick = new QuickSort(vetor);
        quick.organiza();
        System.out.println("------------------");
        for (int i = 0; i <= vetor.length-1; i++) {
            vetor[i].print();
        }        
    }  
}
