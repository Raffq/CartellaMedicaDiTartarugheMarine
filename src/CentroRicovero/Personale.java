package CentroRicovero;

public class Personale {
    String nome;
    String cognome;
    int matricola;
    int stipendio;
    int telefono;
    String email;

    public Personale(String nome, String cognome, int stipendio, int telefono, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.stipendio = stipendio;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getMatricola() {
        return matricola;
    }

    public int getStipendio() {
        return stipendio;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public void setStipendio(int stipendio) {
        this.stipendio = stipendio;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
