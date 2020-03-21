package ordenacao;

import trabalho.Registro;

public class QuickSort {
    Registro[] vet;

    public QuickSort(Registro[] vet) {
        this.vet = vet;
    }
    
    public void organiza(){
        long tempoInicial = System.currentTimeMillis();
        quickSort(0, this.vet.length-1);
        long tempoFinal = System.currentTimeMillis();
        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
    }
    
    protected void  quickSort(int esq, int dir){
        if(esq < dir){
            int pivo = particiona(esq, dir);
            quickSort(esq, pivo-1);
            quickSort(pivo+1, dir);
        }
    }
    
    protected int particiona(int esq, int dir){
        Registro pivo = this.vet[esq];
        int i = (esq + 1), j = dir;
        while (i <= j){
            if (this.vet[i].getArtist().compareToIgnoreCase(pivo.getArtist()) <= 0){
                i++;
            }
            else if (this.vet[j].getArtist().compareToIgnoreCase(pivo.getArtist()) > 0){
                j--;
            }
            else {
                Registro temp = this.vet[i];
                this.vet[i] = this.vet[j];
                this.vet[j] = temp;
                i++;
                j--;
            }
        }
        this.vet[esq] = this.vet[j];
        this.vet[j] = pivo;
        return j;
    }
}
