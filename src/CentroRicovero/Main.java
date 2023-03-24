package CentroRicovero;

import CentroRicoveroDAO.CartellaClinicaDAO;
import CentroRicoveroDAO.CartellaClinicaDAOImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
//TODO: tutte le classi che hanno l'attributo codice o matricola, devono essere generati automaticamente

        CartellaClinica cartellaClinica = new CartellaClinica("grazia", 10,10,10, "caracciolo");
        CartellaClinicaDAOImpl cartellaClinicaDAO = new CartellaClinicaDAOImpl();
        cartellaClinica = cartellaClinicaDAO.get(1);
        System.out.println(cartellaClinica.getLarghezza());
    }
}
