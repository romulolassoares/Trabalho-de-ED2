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
//            //Ordena pelo nome da música
            mergeSort(first, mid);
            mergeSort(mid+1, last);
            mergeByName(first, mid, last);
        }
    }
    //Funcao auxiliar de ordenacao para o nome do artista

     public void mergeByArtist( int first, int mid, int last) {
        // Cria vetores temporarios
        Registro esqVet[] = new Registro[mid - first + 1];
        Registro dirVet[] = new Registro[last - mid];

        // Copia os valores para o vetores temporarios
        for (int i = 0; i < esqVet.length; i++)
            esqVet[i] = this.vet[first + i];
        for (int i = 0; i < dirVet.length; i++)
            dirVet[i] = this.vet[mid + i + 1];
        int esqIndex = 0;
        int dirIndex = 0;

        // Copiando dos vetores temporarios para o vetor original
        for (int i = first; i < last + 1; i++) {
            if (esqIndex < esqVet.length && dirIndex < dirVet.length) {
                //if (esqVet[esqIndex] < dirVet[dirIndex]) {
                if(esqVet[esqIndex].getArtist().compareToIgnoreCase(dirVet[dirIndex].getArtist()) < 0){
                   vet[i] = esqVet[esqIndex];
                   esqIndex++;
                } else {
                    vet[i] = dirVet[dirIndex];
                    dirIndex++;
                }
            } else if (esqIndex < esqVet.length) {
                vet[i] = esqVet[esqIndex];
                esqIndex++;
            } else if (dirIndex < dirVet.length) {
                vet[i] = dirVet[dirIndex];
                dirIndex++;
            }
        }
    }
    //Funcao auxiliar de ordenacao para o nome da música
    protected void mergeByName(int first, int mid, int last) {
        // Cria vetores temporarios
        Registro esqVet[] = new Registro[mid - first + 1];
        Registro dirVet[] = new Registro[last - mid];

        // Copia os valores para o vetores temporarios
        for (int i = 0; i < esqVet.length; i++)
            esqVet[i] = this.vet[first + i];
        for (int i = 0; i < dirVet.length; i++)
            dirVet[i] = this.vet[mid + i + 1];
        int esqIndex = 0;
        int dirIndex = 0;

        // Copiando dos vetores temporarios para o vetor original
        for (int i = first; i < last + 1; i++) {
            if (esqIndex < esqVet.length && dirIndex < dirVet.length) {
                if(esqVet[esqIndex].getArtist().compareToIgnoreCase(dirVet[dirIndex].getArtist())==0){ //Verifica se os nomes dos artistas são iguais
                    if(esqVet[esqIndex].getName().compareToIgnoreCase(dirVet[dirIndex].getName()) < 0){
                       vet[i] = esqVet[esqIndex];
                       esqIndex++;
                    } else {
                        vet[i] = dirVet[dirIndex];
                        dirIndex++;
                    }
                }
            } else if (esqIndex < esqVet.length) {
                vet[i] = esqVet[esqIndex];
                esqIndex++;
            } else if (dirIndex < dirVet.length) {
                vet[i] = dirVet[dirIndex];
                dirIndex++;
            }
        }     
    }
        

}
