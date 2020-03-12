package ordenacao;

import trabalho.Registro;

public class InsertionSort {
    private Registro[] vet;//Vetor que amarzena os dados
    private int tam;//Tamanho do vetor

    //Contrutor
    public InsertionSort(Registro[] vet, int tam) {
        this.vet = vet;
        this.tam = tam;
    }
    //Funcao principal da classe, chamada no main
    public void organiza(){
        insertionSort();
    }
    //Função de ordenação do Insertion Sort
    protected void insertionSort(){
        //Ordena os nomes dos artistas
        for (int j = 2; j < tam; j++) {
            Registro pivo = vet[j];
            int i = j - 1;
            
            while ((i >= 0) && ((vet[i].getArtist().compareToIgnoreCase(pivo.getArtist()) > 0))) {
                vet[i + 1] = vet[i];
                i = i - 1;
            }
            vet[i + 1] = pivo;
        }
        //Ordena os nomes das músicas
        for(int j=2;j<tam;j++){
            Registro pivo = vet[j];
            int i= j-1;
            if((vet[i].getArtist().compareTo(pivo.getArtist()) == 0)){ //Verifica se o nome do artista é igual
                while((i>0) && vet[i].getName().compareToIgnoreCase(pivo.getName())>0){
                vet[i+1] = vet[i];
                i=i-1;
                }
            }
            vet[i+1]=pivo;
        }
    }
}
