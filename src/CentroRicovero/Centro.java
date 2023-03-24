package CentroRicovero;

public class Centro {
    int id_centro;
    String nome;
    Sede sede;

    public Centro(String nome, Sede sede) {
        this.nome = nome;
        this.sede = sede;
    }

    public void setId_centro(int id_centro) {
        this.id_centro = id_centro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public int getId_centro() {
        return id_centro;
    }

    public String getNome() {
        return nome;
    }

    public Sede getSede() {
        return sede;
    }
}
