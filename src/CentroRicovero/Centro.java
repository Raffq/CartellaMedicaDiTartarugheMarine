package CentroRicovero;

public class Centro {
    int id_centro;
    String nome;
    Sede sede;

    public Centro(int id_centro, String nome, Sede sede) {
        this.id_centro = id_centro;
        this.nome = nome;
        this.sede = sede;
    }
}
