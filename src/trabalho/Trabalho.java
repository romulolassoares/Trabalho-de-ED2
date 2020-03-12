/**
 * @author romulo
 */
package trabalho;

import java.io.IOException;
import java.util.Scanner;

public class Trabalho {
    public static void main(String[] args) throws IOException {
        int option;
        Scanner input = new Scanner(System.in);
        Registro[] vetor; //Inicia um vetor de Musica para armazernar os dados do arquivo .csv
        Leitura a = new Leitura(); //Inicializa a classe para executar a leitura do arquivo .csv

        vetor = a.lerArquivo(); //Lê o arquivo .csv e passa para o vetor os dados
            
        for (int i = 0; i < vetor.length; i++) {
            vetor[i].imprimir();
        }
        
    }  
}
