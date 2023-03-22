package CentroRicoveroDAO;

import CentroRicovero.CartellaClinica;

import java.sql.SQLException;
import java.util.List;

public class CartellaClinicaDAOImpl implements CartellaClinicaDAO{
    //TODO:
    @Override
    public CartellaClinica get(int id) throws SQLException {
        try {
            String codeSQL = "SELECT * FROM cartella_clinica WHERE id_tartaruga=?";

        } catch (SQLException e) {

        }
    }

    @Override
    public List getAll() throws SQLException {
        return null;
    }

    @Override
    public int save() throws SQLException {
        return 0;
    }

    @Override
    public int insert() throws SQLException {
        return 0;
    }

    @Override
    public int update() throws SQLException {
        return 0;
    }

    @Override
    public int delete() throws SQLException {
        return 0;
    }
}
