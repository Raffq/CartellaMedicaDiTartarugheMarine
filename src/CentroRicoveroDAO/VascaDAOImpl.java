package CentroRicoveroDAO;

import CentroRicovero.UtilityDatabase;
import CentroRicovero.Vasca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class VascaDAOImpl implements VascaDAO {

    @Override
    public Vasca get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Vasca> getAll() throws SQLException {
        return null;
    }
    //TODO
    @Override
    public void insert(Vasca vasca) throws SQLException {
        //da implementare con le relazioni
    }

    @Override
    public void update(Vasca vasca) throws SQLException {

    }
}
