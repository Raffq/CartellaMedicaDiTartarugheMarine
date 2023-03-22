package CentroRicovero;

public class Indirizzo {
    String via;
    int numero;

    public Indirizzo(String via, int numero) {
        this.via = via;
        this.numero = numero;
    }

    public String getVia() {
        return via;
    }

    public int getNumero() {
        return numero;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
