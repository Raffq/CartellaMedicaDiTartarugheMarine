package CentroRicovero;

public class Sede {
    String nome;
    String indirizzo;

    public Sede(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
}
