package trabalho;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.html.HTML;

public class Leitura {
    private static final char VIRGULA = ',';
    private static final char ASPAS = '"';
    private String arquivoCSV;
    private Registro[] dados; // inicializa o vetor para armazenar os registro lidos do documento .csv
    private int quantidade;
    

    public Leitura(int quantidade) {
        this.arquivoCSV = "dataset.csv";
        this.quantidade = quantidade;
        this.dados = new Registro[this.quantidade];   
    }
    
    public Registro[] lerArquivo() throws IOException {
        try {
            BufferedReader leitura = new BufferedReader(new FileReader(this.arquivoCSV));// Lê o arquivo CSV
            String linha = leitura.readLine();// Lê a primeira linha
            linha = leitura.readLine();// Pula o cabeçalho do arquivo
            int i = 0;
            String texto = " ";
            boolean entreAspas = false;
            int coluna = 0;
            String[] campos = new String[25];// Vetor das colunas no arquivo csv
            while (linha != null && i < this.quantidade) {
                char[] caracteres = linha.toCharArray();// Tranforma a linha lida em um vetor de char
                // Loop para andar em todas os campos do vetor de char
                for (int j = 0; j < caracteres.length;) {
                    // Verifica se não está entre aspas
                    if (entreAspas != true) {
                        if (caracteres[j] == this.VIRGULA) {// Ignora a vírgula
                            coluna++;
                            texto = "";
                            j++;
                        }
                    }
                    // Verifica se o caractere é aspas
                    if ( caracteres[j] == this.ASPAS ) {
                        if (entreAspas) { entreAspas = false; }// Se tiver fora das aspas
                        else { entreAspas = true; }// Se tiver entre aspas
                    }
                    // Verifica se é um campo vazio no vetor
                    if (caracteres[j] == this.ASPAS && j+1 < caracteres.length ) {
                        if(caracteres[j+1] == this.ASPAS ){ texto = ""; }
                    }
                    texto += caracteres[j];// Concatena os caracteres
                    campos[coluna] = texto;// Coloca o texto no vetor das colunas 
                    j++;
                }
                // Retira as aspas
                for (int j = 0; j < campos.length; j++) { campos[j] = campos[j].replaceAll("\"", ""); }
                // Insere os valores no vetor de Registros
                this.dados[i] = new Registro(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8], campos[9], campos[10], campos[11], campos[12], campos[13], campos[14], campos[15], campos[16], campos[17], campos[18], campos[19], campos[20], campos[21], campos[22], campos[23], campos[24]);
                i++;
                linha = leitura.readLine();// Lê a proxima linha
                coluna = 0;// Volta para a primeira coluna
                texto = "";// Reseta o texto
            }  
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erro na leitura do arquivo."); //mensagem de erro caso não seja possivel realizar a leitura do arquivo
        }
        return this.dados;
    }
        
}