package CentroRicovero;

public class Centro {
    int id_centro;
    String nome;

    public Centro(String nome) {
        this.nome = nome;
    }

    public void setId_centro(int id_centro) {
        this.id_centro = id_centro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_centro() {
        return id_centro;
    }

    public String getNome() {
        return nome;
    }

}
