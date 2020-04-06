package trabalho;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Leitura {
    private static final String VIRGULA = ","; //Variavel utilizada para tratar a leitura do arquivo .csv
    private Registro[] dados; // inicializa o vetor para armazenar os registro lidos do documento .csv
    private int numColunas;

    public Leitura() {
        this.dados = new Registro[100];
    }
   
    public Registro[] lerArquivo() throws IOException{
        int i = 0;
        String ASPAS =  "\",\"";
        try {
            BufferedReader leitura = new BufferedReader(new FileReader("dataset.txt")); //Leitura do arquivo .csv de Registros
            String linha = leitura.readLine(); //Variavel que lê a primeira linha do arquivo .csv
            String[] cabecalho = linha.split(VIRGULA);//Cabeçalho do arquivo .csv
            this.numColunas = cabecalho.length ;
            linha = leitura.readLine();
            while (linha != null && i < 100) {
                
                //System.out.println(linha.toString());
                 String[] aCampos = linha.split(ASPAS);
                
                 for (int j = 0; j < aCampos.length; j++) {
                        if (aCampos[j].contains("\"")) {
                            String regex = "\"";
                            Pattern p = Pattern.compile(regex);
                            Matcher m = p.matcher(aCampos[j]);

                            while (m.find()) {
                                aCampos[j] = aCampos[j].replace("\"", "");
                            }
                        }
                    } 
               this.dados[i] = new Registro(aCampos[0], aCampos[1], aCampos[2], aCampos[3], aCampos[4], aCampos[5], aCampos[6], aCampos[7], aCampos[8], aCampos[9], aCampos[10], aCampos[11], aCampos[12], aCampos[13], aCampos[14], aCampos[15], aCampos[16], aCampos[17], aCampos[18], aCampos[19], aCampos[20], aCampos[21], aCampos[22], aCampos[23], aCampos[24]);
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
