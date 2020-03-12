package trabalho;

public class Registro {
private String id;
    private String name;
    private String artist;
    //Construtor
    public Registro(String id, String nome, String artist){
        this.id = id;
        this.name = nome;
        this.artist = artist;
    }
    //Gets
    public String getArtist() {
        return artist;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    //Sets
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    //Função para imprimir os dados
    public void imprimir(){
        System.out.println(this.id + "|" + this.name + "|" + this.artist);
    }
}
