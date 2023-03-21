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
}
