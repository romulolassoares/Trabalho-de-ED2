package trabalho;

import java.io.IOException;
import java.util.ArrayList;
import ordenacao.QuickSort;

public class OpcoesMenu {
    private ArrayList<Integer> parametrosN;
    private Leitura leitura; //Inicializa a classe para executar a leitura do arquivo .csv
    private Escrita escrita; //Inicializa a classe para executar a escrita do arquivo saida.txt
    
    //Ordenadores
    QuickSort quick;
    
    public OpcoesMenu() throws IOException {
        leitura = new Leitura();
        escrita = new Escrita();
        quick = new QuickSort();
        
        leitura.preCarregarArquivo();
    }
    
    //INÍCIO - PARTE 1
        //INÍCIO - CENÁRIO 1
    public void executarParte1Cenario1() throws IOException {
        Registro[] vetor;
        parametrosN = leitura.lerParametros("Parte 1 - cenario 1.txt");
        if(parametrosN != null) {
            int[][] media = new int[parametrosN.size()][3];
            
            for(int j=0; j<5; j++) { //Executa 5 vezes os testes
                escrita.imprimeCabecalioCenario1e2("Execução " + (j+1));
                for(int k=0; k<parametrosN.size(); k++) {
                    vetor = leitura.lerArquivo(parametrosN.get(k)); //Lê o arquivo .csv e passa para o vetor os dados

                    if(vetor != null) {
                        System.out.println("Parte 1 - Cenário 1: Ordenando estrutura com QuickSort Recursivo...");
                        quick.ordena_Recursivo(vetor);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");

                        media[k][0] += Metrica.getTempo();
                        media[k][1] += Metrica.getCopias();
                        media[k][2] += Metrica.getComparacoes();

                        escrita.imprimeDadosCenario1e2(parametrosN.get(k), Metrica.getTempo(), Metrica.getCopias(), Metrica.getComparacoes());
                        Metrica.clear();
                    }
                }
                escrita.impressao("\n");
            }
            //Imprie a média
            escrita.imprimeCabecalioCenario1e2("Média");
            for(int l=0; l<parametrosN.size(); l++) {
                escrita.imprimeDadosCenario1e2(parametrosN.get(l), (long)(media[l][0]/5), media[l][1]/5, media[l][2]/5);
            }
        } else {
            System.out.println("Nenhum parâmetro encoontrado");
        }
    }
        //FINAL - CENÁRIO 1
        //INICIO - CENÁRIO 2
    public void executarParte1Cenario2(int[] k) throws IOException {
        Registro[] vetorR;
        Registro[] vetorM;
        Registro[] vetorI;
        parametrosN = leitura.lerParametros("Parte 1 - cenario 2.txt");
        if(parametrosN != null) {
            int[][] mediaR = new int[parametrosN.size()][3]; //Armazena a média do QuickSort Recursivo
            int[][][] mediaM = new int[k.length][parametrosN.size()][3]; //Armazena a média do QuickSort Mediana
            int[][] mediaI = new int[parametrosN.size()][3]; //Armazena a média do QuickSort Inserção
            
            for(int j=0; j<5; j++) { //Executa 5 vezes os testes
                for(int l=0; l<parametrosN.size(); l++) {
                    vetorR = leitura.lerArquivo(parametrosN.get(l));
                    if(vetorR != null) {
                        vetorM = (Registro[])vetorR.clone();
                        //vetorI = (Registro[])vetorR.clone();
                    
                        System.out.println("Parte 1 - Cenário 2: Ordenando estrutura com QuickSort Recursivo...");
                        quick.ordena_Recursivo(vetorR);
                        System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                        mediaR[l][0] += Metrica.getTempo();
                        mediaR[l][1] += Metrica.getCopias();
                        mediaR[l][2] += Metrica.getComparacoes();
                        Metrica.clear();

                        for(int m=0; m<k.length; m++) {
                            System.out.println("Parte 1 - Cenário 2: Ordenando estrutura com QuickSort Mediana...");
                            quick.ordena_Mediana(vetorR, k[m]);
                            System.out.println("Ordenação feita em = " + Metrica.getTempo() + " ms\n");
                            mediaM[m][l][0] += Metrica.getTempo();
                            mediaM[m][l][1] += Metrica.getCopias();
                            mediaM[m][l][2] += Metrica.getComparacoes();
                            Metrica.clear();
                        }
                    }
                }
            }
            
            //Imprime Resultados
            int n, o;
            //QuickSort Recursivo
            escrita.imprimeCabecalioCenario1e2("Média QuickSort Recursivo");
            for(n=0; n<parametrosN.size(); n++) {
                escrita.imprimeDadosCenario1e2(parametrosN.get(n), (mediaR[n][0]/5), (mediaR[n][1]/5), (mediaR[n][2]/5));
            }
            
            //QuickSort Mediana
            for(o=0; o<k.length; o++) {
                escrita.imprimeCabecalioCenario1e2("Média QuickSort Mediana com K = "+k[o]);
                for(n=0; n<parametrosN.size(); n++) {
                    escrita.imprimeDadosCenario1e2(parametrosN.get(n), (mediaM[o][n][0]/5), (mediaM[o][n][1]/5), (mediaM[o][n][2]/5));
                }
            }
        } else {
            System.out.println("Nenhum parâmetro encontrado");
        }
    }
        //FINAL - CENÁRIO 2
        //INÍCIO - CENÁRIO 3
    
        //FINAL - CENÁRIO 3
        //INÍCIO - CENÁRIO 4
    
        //FINAL - CENÁRIO 4
    //FINAL - PARTE 1
    
    //INÍCIO - PARTE 2
    
    //FINAL - PARTE 2
    
    //Início - Funções de uso geral
    public void closeEscrita() throws IOException {
        escrita.close();
    }
    //Final - Funções de uso geral
}
