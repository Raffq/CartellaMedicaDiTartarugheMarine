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

    public String getNome_spiaggia() {
        return nome_spiaggia;
    }

    public String getComune() {
        return comune;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getNazione() {
        return nazione;
    }

    public int getLatitudine() {
        return latitudine;
    }

    public int getLongitudine() {
        return longitudine;
    }

    public int getTemperatura_acqua() {
        return temperatura_acqua;
    }

    public String getTipo_fondale() {
        return tipo_fondale;
    }

    public void setNome_spiaggia(String nome_spiaggia) {
        this.nome_spiaggia = nome_spiaggia;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public void setLatitudine(int latitudine) {
        this.latitudine = latitudine;
    }

    public void setLongitudine(int longitudine) {
        this.longitudine = longitudine;
    }

    public void setTemperatura_acqua(int temperatura_acqua) {
        this.temperatura_acqua = temperatura_acqua;
    }

    public void setTipo_fondale(String tipo_fondale) {
        this.tipo_fondale = tipo_fondale;
    }
}
