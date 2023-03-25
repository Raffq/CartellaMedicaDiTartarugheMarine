package CentroRicoveroDAO;

import CentroRicovero.Tartaruga;

import java.sql.SQLException;

public interface TartarugaDAO extends DAO<Tartaruga> {
    public void updateId(Tartaruga tartaruga) throws SQLException;
}
