package CentroRicovero;

public class Vasca {
    int codice;
    boolean occupata;


    public Vasca() {
        this.occupata = false;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public boolean isOccupata() {
        return occupata;
    }

    public void setOccupata(boolean occupata){
        this.occupata = occupata;
    }
}
