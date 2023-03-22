package CentroRicovero;

public class CartellaClinica {
    String specie;
    int lunghezza;
    int larghezza;
    int peso;
    LuogoRitrovamento luogoRitrovamento;

    public CartellaClinica(String specie, int lunghezza, int larghezza, int peso, LuogoRitrovamento luogoRitrovamento) {
        this.specie = specie;
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.peso = peso;
        this.luogoRitrovamento = luogoRitrovamento;
    }

    public String getSpecie() {
        return specie;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public int getPeso() {
        return peso;
    }

    public LuogoRitrovamento getLuogoRitrovamento() {
        return luogoRitrovamento;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }

    public void setLarghezza(int larghezza) {
        this.larghezza = larghezza;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setLuogoRitrovamento(LuogoRitrovamento luogoRitrovamento) {
        this.luogoRitrovamento = luogoRitrovamento;
    }
}
