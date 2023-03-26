package CentroRicoveroDAO;

import CentroRicovero.CartellaClinica;
import CentroRicovero.TecnicoLab;
import CentroRicovero.UtilityDatabase;
import CentroRicovero.Vasca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VascaDAOImpl implements VascaDAO {

    @Override
    public Vasca get(int id) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        Vasca vasca = null;

        String codeSQL = "SELECT * FROM vasca WHERE codice=?";
        PreparedStatement statement = conn.prepareStatement(codeSQL);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        try {
            if (resultSet.next()) {
                Boolean occupata = resultSet.getBoolean("occupata");
                int codice = resultSet.getInt("codice");
                vasca = new Vasca();
                vasca.setOccupata(occupata);
                vasca.setCodice(codice);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");

        }
        return vasca;
    }

    @Override
    public List<Vasca> getAll() throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        String codeSQL = "SELECT * FROM vasca";
        PreparedStatement statement = conn.prepareStatement(codeSQL);

        ArrayList<Vasca> vascaList = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery();
        try {
            while (resultSet.next()){
                boolean occupata = resultSet.getBoolean("occupata");
                int codice = resultSet.getInt("codice");

                Vasca vasca = new Vasca();
                vasca.setCodice(codice);
                vasca.setOccupata(occupata);
                vascaList.add(vasca);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return vascaList;
    }

    @Override
    public Vasca getLast() throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        Vasca vasca = null;

        String codeSQL = "SELECT * FROM vasca WHERE codice=currval('vasca_codice_seq')";
        PreparedStatement statement = conn.prepareStatement(codeSQL);
        ResultSet resultSet = statement.executeQuery();
        try {
            if (resultSet.next()) {
                Boolean occupata = resultSet.getBoolean("occupata");
                int codice = resultSet.getInt("codice");
                vasca = new Vasca();
                vasca.setOccupata(occupata);
                vasca.setCodice(codice);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");

        }
        return vasca;
    }

    @Override
    public void insert(Vasca vasca) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "INSERT INTO vasca(occupata) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setBoolean(1, vasca.isOccupata());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }

    @Override
    public void update(Vasca vasca) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "UPDATE vasca SET occupata = ?";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setBoolean(1, vasca.isOccupata());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }
}

