package trabalho;


public class Metrica {
    private static int comparacoes;
    private static int copias;
    private static long tempo;
    
    public static void clear() {
        comparacoes = 0;
        copias = 0;
        tempo = 0;
    }
    
    public static boolean incrementaComparacoes() {
        Metrica.comparacoes++;
        return true;
    }
    
    public static void incrementaCopias() {
        Metrica.copias++;
    }
    
    public static void setTempo(long tempo) {
        Metrica.tempo = tempo;
    }
    
    public static int getComparacoes() {
        return comparacoes;
    }
    public static int getCopias() {
        return copias;
    }
    public static long getTempo() {
        return tempo;
    }
}
