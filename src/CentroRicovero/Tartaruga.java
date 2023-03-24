package CentroRicovero;

public class Tartaruga {
    int id_tartaruga;
    String nome;
    int targhetta;
    boolean presente_nel_centro;

    public Tartaruga(String nome) {
        this.nome = nome;
        this.presente_nel_centro = true;
    }

    public int getId_tartaruga() {
        return id_tartaruga;
    }

    public String getNome() {
        return nome;
    }

    public boolean isPresente_nel_centro() {
        return presente_nel_centro;
    }

    public int getTarghetta(){
        return targhetta;
    }

    public void setId_tartaruga(int id_tartaruga) {
        this.id_tartaruga = id_tartaruga;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPresente_nel_centro(boolean presente_nel_centro) {
        this.presente_nel_centro = presente_nel_centro;
    }

    public void setTarghetta(int targhetta){
        this.targhetta = targhetta;
    }
}
