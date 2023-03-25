package CentroRicoveroDAO;

import CentroRicovero.Sede;
import CentroRicovero.UtilityDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SedeDAOImpl implements SedeDAO{

    @Override
    public Sede get(int id) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        Sede sede = null;

        String codeSQL = "SELECT * FROM sede WHERE id_sede=?";
        PreparedStatement statement = conn.prepareStatement(codeSQL);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        try {
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String indirizzo = resultSet.getString("indirizzo");
                String provincia = resultSet.getString("provincia");
                String citta = resultSet.getString("citta");
                int cap = resultSet.getInt("cap");
                sede = new Sede(nome, indirizzo, provincia, citta, cap);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");

        }
        return sede;
    }

    @Override
    public List<Sede> getAll() throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        String codeSQL = "SELECT * FROM sede";
        PreparedStatement statement = conn.prepareStatement(codeSQL);

        ArrayList<Sede> sedeList = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery();
        try {
            while (resultSet.next()){
                String nome = resultSet.getString("nome");
                int id_sede = resultSet.getInt("id_sede");
                String indirizzo = resultSet.getString("indirizzo");
                String provincia = resultSet.getString("provincia");
                String citta = resultSet.getString("citta");
                int cap = resultSet.getInt("cap");

                Sede sede = new Sede(nome, indirizzo, provincia, citta, cap);
                sede.setId_sede(id_sede);
                sedeList.add(sede);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto");
        }
        return sedeList;
    }

    @Override
    public void insert(Sede sede) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "INSERT INTO sede(nome, indirizzo, provincia, citta, cap) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, sede.getNome());
            statement.setString(2, sede.getIndirizzo());
            statement.setString(3, sede.getProvincia());
            statement.setString(4, sede.getCitta());
            statement.setInt(5, sede.getCap());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }

    @Override
    public void update(Sede sede) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try{
            String codeSQL = "UPDATE sede SET nome = ?, indirizzo = ?, provincia = ?, citta = ?, cap = ?";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1,sede.getNome());
            statement.setString(2,sede.getIndirizzo());
            statement.setString(3,sede.getProvincia());
            statement.setString(4,sede.getCitta());
            statement.setInt(5,sede.getCap());
            statement.execute();

        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }
}
