package trabalho;

import java.io.IOException;
import java.util.ArrayList;
import ordenacao.HeapSort;
import ordenacao.InsertionSort;
import ordenacao.MergeSort;
import ordenacao.QuickSort;

public class OpcoesMenu {
    private ArrayList<Integer> parametrosN;
    private Leitura leitura; //Inicializa a classe para executar a leitura do arquivo .csv
    private Escrita escrita; //Inicializa a classe para executar a escrita do arquivo saida.txt
    
    //Ordenadores
    QuickSort quickSort;
    InsertionSort insertionSort;
    MergeSort mergeSort;
    HeapSort heapSort;
    
    public OpcoesMenu() throws IOException {
        leitura = new Leitura();
        escrita = new Escrita();
        quickSort = new QuickSort();
        insertionSort = new InsertionSort();
        mergeSort = new MergeSort();
        heapSort = new HeapSort();
        
        leitura.preCarregarArquivo();
    }
    
    //INÍCIO - PARTE 1
        //INÍCIO - CENÁRIO 1
    public void executarParte1Cenario1() throws IOException {
        Registro[] vetor;
        int execucoes = 5;
        parametrosN = leitura.lerParametros("Parte 1 - cenario 1.txt");
        if(parametrosN != null) {
            int[][] media = new int[parametrosN.size()][3];
            
            for(int j=0; j<execucoes; j++) { //Executa 5 vezes os testes

                for(int k=0; k<parametrosN.size(); k++) {
                    vetor = leitura.lerArquivo(parametrosN.get(k)); //Lê o arquivo .csv e passa para o vetor os dados

                    if(vetor != null) {
                        System.out.println("Parte 1 - Cenário 1: Ordenando estrutura com QuickSort Recursivo...");
                        quickSort.ordena_Recursivo(vetor);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");

                        media[k][0] += Metrica.getTempo();
                        media[k][1] += Metrica.getCopias();
                        media[k][2] += Metrica.getComparacoes();

                        Metrica.clear();
                    }
                }
            }
            //Imprie a média
            escrita.imprimeCabecalioCenario1e2(1, "Média");
            for(int l=0; l<parametrosN.size(); l++) {
                escrita.imprimeDadosCenario1e2(parametrosN.get(l), (long)(media[l][0]/execucoes), media[l][1]/execucoes, media[l][2]/execucoes);
            }
        } else {
            System.out.println("Nenhum parâmetro encoontrado");
        }
    }
        //FINAL - CENÁRIO 1
        //INICIO - CENÁRIO 2
    public void executarParte1Cenario2(int[] k, int[] m) throws IOException {
        Registro[] vetorR;
        Registro[][] vetorM = new Registro[k.length][];
        Registro[][] vetorI = new Registro[m.length][];
        int execucoes = 5;
        parametrosN = leitura.lerParametros("Parte 1 - cenario 2.txt");
        if(parametrosN != null) {
            int[][] mediaR = new int[parametrosN.size()][3]; //Armazena a média do QuickSort Recursivo
            int[][][] mediaM = new int[k.length][parametrosN.size()][3]; //Armazena a média do QuickSort Mediana
            int[][][] mediaI = new int[m.length][parametrosN.size()][3]; //Armazena a média do QuickSort Inserção
            
            for(int j=0; j<execucoes; j++) { //Executa 5 vezes os testes

                for(int l=0; l<parametrosN.size(); l++) {
                    vetorR = leitura.lerArquivo(parametrosN.get(l));
                    if(vetorR != null) {
                        int aux;
                        for(aux = 0; aux<k.length; aux++) { vetorM[aux] = (Registro[])vetorR.clone(); }
                        for(aux = 0; aux<m.length; aux++) { vetorI[aux] = (Registro[])vetorR.clone(); }
                    
                        //Ordena QuickSort Recursivo
                        System.out.println("Parte 1 - Cenário 2: Ordenando estrutura com QuickSort Recursivo...");
                        quickSort.ordena_Recursivo(vetorR);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                        mediaR[l][0] += Metrica.getTempo();
                        mediaR[l][1] += Metrica.getCopias();
                        mediaR[l][2] += Metrica.getComparacoes();
                        Metrica.clear();

                        //Ordena QuickSort Mediana
                        for(aux=0; aux<k.length; aux++) {
                            System.out.println("Parte 1 - Cenário 2: Ordenando estrutura com QuickSort Mediana...");
                            quickSort.ordena_Mediana(vetorM[aux], k[aux]);
                            System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                            mediaM[aux][l][0] += Metrica.getTempo();
                            mediaM[aux][l][1] += Metrica.getCopias();
                            mediaM[aux][l][2] += Metrica.getComparacoes();
                            Metrica.clear();
                        }
                        
                        //Ordena QuickSort Inserção
                        for(aux=0; aux<m.length; aux++) {
                            System.out.println("Parte 1 - Cenário 2: Ordenando estrutura com QuickSort Inserção...");
                            quickSort.ordena_Insercao(vetorI[aux], m[aux]);
                            System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                            mediaI[aux][l][0] += Metrica.getTempo();
                            mediaI[aux][l][1] += Metrica.getCopias();
                            mediaI[aux][l][2] += Metrica.getComparacoes();
                            Metrica.clear();
                        }
                    }
                }
            }
            
            //Imprime Resultados
            int n, o;
            //QuickSort Recursivo
            escrita.imprimeCabecalioCenario1e2(2, "Média QuickSort Recursivo");
            for(n=0; n<parametrosN.size(); n++) {
                escrita.imprimeDadosCenario1e2(parametrosN.get(n), (long)(mediaR[n][0]/execucoes), (mediaR[n][1]/execucoes), (mediaR[n][2]/execucoes));
            }
            
            //QuickSort Mediana
            for(o=0; o<k.length; o++) {
                escrita.imprimeCabecalioCenario1e2(2, "Média QuickSort Mediana com K = "+k[o]);
                for(n=0; n<parametrosN.size(); n++) {
                    escrita.imprimeDadosCenario1e2(parametrosN.get(n), (long)(mediaM[o][n][0]/execucoes), (mediaM[o][n][1]/execucoes), (mediaM[o][n][2]/execucoes));
                }
            }
            
            //QuickSort Inserção
            for(o=0; o<m.length; o++) {
                escrita.imprimeCabecalioCenario1e2(2, "Média QuickSort Inserção com M = "+m[o]);
                for(n=0; n<parametrosN.size(); n++) {
                    escrita.imprimeDadosCenario1e2(parametrosN.get(n), (long)(mediaI[o][n][0]/execucoes), (mediaI[o][n][1]/execucoes), (mediaI[o][n][2]/execucoes));
                }
            }
        } else {
            System.out.println("Nenhum parâmetro encontrado");
        }
    }
        //FINAL - CENÁRIO 2
        //INÍCIO - CENÁRIO 3
    public void executarParte1Cenario3() throws IOException {
        
    }
        //FINAL - CENÁRIO 3
        //INÍCIO - CENÁRIO 4
    
        //FINAL - CENÁRIO 4
    //FINAL - PARTE 1
    
    //INÍCIO - PARTE 2
    
    //FINAL - PARTE 2
    
    private boolean testeEquals(Registro[] vetor) {
        for(int i=0; i<vetor.length; i++) {
            for(int j=i+1; j<vetor.length; j++) {
                if(vetor[i].getTitle().equals(vetor[j].getTitle())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //Início - Funções de uso geral
    public void closeEscrita() throws IOException {
        escrita.close();
    }
    //Final - Funções de uso geral
}
