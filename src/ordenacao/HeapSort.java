package ordenacao;

import trabalho.Metrica;
import trabalho.Registro;

public class HeapSort {
    
    //Construtor
    public HeapSort() {
        
    }
    
    public void ordena(Registro[] vetor) {
        long tempoInicial = System.currentTimeMillis();
        heapSort(vetor, vetor.length);
        long tempoFinal = System.currentTimeMillis();
        Metrica.setTempo(tempoFinal-tempoInicial);
    }
    
    private void heapSort(Registro[] vetor, int n) {
        buildMaxHeap(vetor, n);
        for(int i=n-1; i>0; i--) {
            trocar(0, i, vetor);
            maxHeapify(vetor, 0, i);
        }
    }
    
    private void buildMaxHeap(Registro[] vetor, int n) {
        for(int i=n/2 - 1; i>=0; i--) {
            maxHeapify(vetor, i, n);
        }
    }
    
    private void maxHeapify(Registro[] vetor, int i, int n) {
        int m = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 

        // If left child is larger than root 
        if (l < n && (vetor[l].getTitle().compareToIgnoreCase(vetor[i].getTitle()) > 0)) {
            m = l; 
        }

        if (r < n && vetor[r].getTitle().compareToIgnoreCase(vetor[m].getTitle()) > 0) 
            m = r; 

        // If largest is not root 
        if (m != i) 
        { 
            trocar(i, m, vetor);

            // Recursively heapify the affected sub-tree 
            maxHeapify(vetor, m, n);
        } 
    }
    
    private void trocar(int i, int j, Registro[] vetor) {
        Registro tmp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = tmp;
    }
}
