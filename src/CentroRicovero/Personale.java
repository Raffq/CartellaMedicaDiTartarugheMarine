package CentroRicovero;

public class Personale {
    String nome;
    String cognome;
    int matricola;
    int stipendio;
    int telefono;
    String email;

    public Personale(String nome, String cognome, int matricola, int stipendio, int telefono, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.telefono = telefono;
        this.email = email;
    }
}
