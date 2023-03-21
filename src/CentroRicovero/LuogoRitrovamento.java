package CentroRicovero;

public class LuogoRitrovamento {
    String nome_spiaggia;
    String comune;
    String provincia;
    String nazione;
    int latitudine;
    int longitudine;
    int temperatura_acqua;
    String tipo_fondale;

    public LuogoRitrovamento(String nome_spiaggia, String comune, String provincia, String nazione, int latitudine, int longitudine, int temperatura_acqua, String tipo_fondale) {
        this.nome_spiaggia = nome_spiaggia;
        this.comune = comune;
        this.provincia = provincia;
        this.nazione = nazione;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.temperatura_acqua = temperatura_acqua;
        this.tipo_fondale = tipo_fondale;
    }
}
