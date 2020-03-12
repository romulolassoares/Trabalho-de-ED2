package trabalho;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Leitura {
    private static final String VIRGULA = ","; //Variavel utilizada para tratar a leitura do arquivo .csv
    private Musica[] dados; // inicializa o vetor para armazenar os registro lidos do documento .csv
    private int numColunas;

    public Leitura() {
        this.dados = new Musica[100];
    }
   
    public Musica[] lerArquivo() throws IOException{
        int i = 0;
        try {
            BufferedReader leitura = new BufferedReader(new FileReader("top2018.csv")); //Leitura do arquivo .csv de Musicas
            String linha = leitura.readLine(); //Variavel que lê a primeira linha do arquivo .csv
            String[] cabecalho = linha.split(VIRGULA);//Cabeçalho do arquivo .csv
            this.numColunas = cabecalho.length ;
            linha = leitura.readLine();
            while (linha != null) {
                       //TRATAMENTO DE ENTRADA (,)
                String[] aCampos = linha.split(VIRGULA);//Vetor que armazena temporariamente cada campo lido do .csv 
                if(aCampos.length > numColunas){//Verifica se a linha lida passou do numero de colunas corretos
                    int dif = aCampos.length - 16;//Numeros de colunas erradas
                    for (int e = 2; e <= dif+1; e++) {//Concerta o campo do nome da música
                        aCampos[1] += " " + aCampos[e];
                    }
                    for (int d = 2; d <= 15; d++) {//Corrigi os campos q estavam errados
                        aCampos[d] = aCampos[d+dif];
                    }   
                    //OBS.: As colunas que foram a mais não somen
                } 
                this.dados[i] = new Musica(aCampos[0], aCampos[1], aCampos[2]);//Adiciona as informações no vetor de Musica com as informções do arquivo .csv
                i++; //incrementa a variavel de controle
                linha = leitura.readLine(); //lê a proxima linha   
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erro na leitura do arquivo."); //mensagem de erro caso não seja possivel realizar a leitura do arquivo
        }
        return this.dados;
    }
}
