package ordenacao;

import java.util.ArrayList;
import java.util.Random;
import trabalho.Metrica;
import trabalho.Registro;

public class QuickSort {
    
    //INÍCIO - QUICKSORT RECURSIVO
    public void ordena_Recursivo(Registro[] vetor){
        long tempoInicial = System.currentTimeMillis();
        quickSort_Recursivo(0, vetor.length-1, vetor);
        long tempoFinal = System.currentTimeMillis();
        Metrica.setTempo(tempoFinal-tempoInicial);
    }
    private void  quickSort_Recursivo(int esq, int dir, Registro[] vetor){
        if(esq < dir){
            int pivo = particiona_Recursivo(esq, dir, vetor);
            quickSort_Recursivo(esq, pivo-1, vetor);
            quickSort_Recursivo(pivo+1, dir, vetor);
        }
    }
    private int particiona_Recursivo(int esq, int dir, Registro[] vetor){
        Registro pivo = vetor[esq];
        int i = (esq + 1);
        int j = dir;
        while (i <= j){
            if (vetor[i].getTitle().compareToIgnoreCase(pivo.getTitle()) <= 0 && Metrica.incrementaComparacoes()){
                i++;
            }
            else if (vetor[j].getTitle().compareToIgnoreCase(pivo.getTitle()) > 0 && Metrica.incrementaComparacoes()){
                j--;
            }
            else {
                troca(i, j, vetor);
                i++;
                j--;
            }
        }
        vetor[esq] = vetor[j];
        vetor[j] = pivo;
        return j;
    }
    //FINAL - QUICKSORT RECURSIVO
    
    //INÍCIO - QUICKSORT MEDIANA
    public void ordena_Mediana(Registro[] vetor, int k) {
        long tempoInicial = System.currentTimeMillis();
        quickSort_Mediana(0, vetor.length-1, vetor, k);
        long tempoFinal = System.currentTimeMillis();
        Metrica.setTempo(tempoFinal-tempoInicial);
    }
    private void quickSort_Mediana(int esq, int dir, Registro[] vetor, int k) {
        if(esq < dir) {
            int pivo = particiona_Mediana(esq, dir, vetor, k);
            quickSort_Mediana(esq, pivo-1, vetor, k);
            quickSort_Mediana(pivo+1, dir, vetor, k);
        }
    }
    private int particiona_Mediana(int esq, int dir, Registro[] vetor, int k) {
        //Escolha do pivo através da mediana de k elementos aleatórios
        Registro pivo;
        int i, j;
        if((dir-esq) > k) {
            Random random = new Random(System.currentTimeMillis());
            Registro[] auxPivo = new Registro[k];
            ArrayList<Integer> numAleatorios = new ArrayList();
            boolean existe;
            int aleatorio;
            for(int n=0; n<k; ){ //Escolhe k elementos eleatórios
                aleatorio = random.nextInt(dir-esq)+esq;
                existe = false;
                for(int l=0; l<numAleatorios.size(); l++) {
                    if(aleatorio == numAleatorios.get(l)) {
                        existe = true;
                    }
                }
                
                if(!existe) {
                    numAleatorios.add(aleatorio);
                    n++;
                }
            }
            Registro[] possiveisPivos = new Registro[k];
            for(int m=0; m<k; m++) {
                possiveisPivos[m] = vetor[numAleatorios.get(m)];
            }
            ordena_Recursivo(possiveisPivos); //Ordenação do vetor de possiveis pivos com o QuickSort Recursivo
            pivo = possiveisPivos[(k-1)/2]; //Escolhe o registro mediano
            i = esq;
            j = dir;
        } else { //Caso a partição seja menor que k, ele escolhe o primeiro elemento como pivo
            pivo = vetor[esq];
            i = (esq + 1);
            j = dir;
        }
        //Ordenação QuickSort normal
        while (i <= j){
            if (vetor[i].getTitle().compareToIgnoreCase(pivo.getTitle()) <= 0 && Metrica.incrementaComparacoes()){
                i++;
            }
            else if (vetor[j].getTitle().compareToIgnoreCase(pivo.getTitle()) > 0 && Metrica.incrementaComparacoes()){
                j--;
            }
            else {
                troca(i, j, vetor);
                i++;
                j--;
            }
        }
        vetor[esq] = vetor[j];
        vetor[j] = pivo;
        return j;
    }
    //FINAL - QUICKSORT MEDIANA
    
    //Início - Funções de uso geral
    private void troca(int i, int j, Registro[] vetor) {
        Registro temp = vetor[i];
        Metrica.incrementaCopias();//Copia feita na linha anterior
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
    //Final - Funções de uso geral
}
