package ordenacao;

import trabalho.Registro;

public class MergeSort {
    private Registro[] vet;//Vetor que amarzena os dados
    private Registro[] auxVet;//Vetor auxiliar para auxiliar na ordenação
    
    //Construtor
    public MergeSort(Registro[] vetor) {
        this.vet = vetor;
        this.auxVet = new Registro[vetor.length];
    }
    //Funcao principal da classe, chamada no main
    public void organiza(){
        long tempoInicial = System.currentTimeMillis();
        mergeSort(0, this.vet.length - 1);
        long tempoFinal = System.currentTimeMillis();
        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
    }
    //Faz a ordenacao do this.vetor
    protected void mergeSort(int first, int last) {
        if(first < last){
            int mid=(first+(last))/2;
            //Ordena pelo nome do Artista
            mergeSort(first, mid);
            mergeSort(mid+1, last);
            mergeByArtist(first, mid, last);
            //Ordena pelo nome da música
            mergeSort(first, mid);
            mergeSort(mid+1, last);
            mergeByName(first, mid, last);
        }
    }
    //Funcao auxiliar de ordenacao para o nome do artista
    protected void mergeByArtist(int first, int mid, int last) {
        int i = first;//i1
        int j = mid+1;//i2
        int k = first;
       
        while (i <= mid && j <= last) {
            if (this.vet[i].getArtist().compareToIgnoreCase(this.vet[j].getArtist())<0) {
                this.auxVet[k] = this.vet[i];
                i++;
                k++;
            } else {
                this.auxVet[k] = this.vet[j];
                j++;
                k++;
            }
        } 
        while(i<=mid){
            this.auxVet[k] = this.vet[i];
            i++;
            k++;
        }
        while(j<=last){
            this.auxVet[k] = this.vet[j];
            j++;
            k++;
        }
        for (int x = first; x <= last; i++) {
            this.vet[x]=this.auxVet[x];
        }
    }
    //Funcao auxiliar de ordenacao para o nome da música
    protected void mergeByName(int first, int mid, int last) {
        int i = first;//i1
        int j = mid+1;//i2
        int k = first;
        
        while (i <= mid && j <= last) {
            if(this.vet[i].getArtist().compareToIgnoreCase(this.vet[j].getArtist())==0){ //Verifica se os nomes dos artistas são iguais
                if (this.vet[i].getName().compareToIgnoreCase(this.vet[j].getName())<0) {
                    this.auxVet[k] = this.vet[i];
                    i++;
                    k++;
                } else {
                    this.auxVet[k] = this.vet[j];
                    j++;
                    k++;
                }
            } 
            while(i<=mid){
                this.auxVet[k] = this.vet[i];
                i++;
                k++;
            }
            while(j<=last){
                this.auxVet[k] = this.vet[j];
                j++;
                k++;
            }
            for (int x = first; x <= last; i++) {
                this.vet[x]=this.auxVet[x];
            }
       }
    }

}
