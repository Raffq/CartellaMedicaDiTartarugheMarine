package CentroRicovero;

public class Sede{
    String nome;
    int id_sede;
    String indirizzo;
    String provincia;
    String citta;
    int cap;

    public Sede(String nome, String indirizzo, String provincia, String citta, int cap) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.provincia = provincia;
        this.citta = citta;
        this.cap = cap;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public int getId_sede() {
        return id_sede;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getCitta() {
        return citta;
    }

    public int getCap() {
        return cap;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }
}
