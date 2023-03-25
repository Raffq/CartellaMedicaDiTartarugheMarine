package CentroRicoveroDAO;

import CentroRicovero.TecnicoLab;
import CentroRicovero.UtilityDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TecnicoLabDAOImpl implements TecnicoLabDAO{
    @Override
    public TecnicoLab get(int id) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();

        TecnicoLab tecnicoLab = null;

        String codeSQL = "SELECT * FROM tecnico_lab WHERE matricola = ?";
        PreparedStatement statement = conn.prepareStatement(codeSQL);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        try {
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cognome = resultSet.getString("cognome");
                int matricola = resultSet.getInt("matricola");
                int stipendio = resultSet.getInt("stipendio");
                int telefono = resultSet.getInt("telefono");
                String email = resultSet.getString("email");

                tecnicoLab = new TecnicoLab(nome, cognome, stipendio, telefono, email);
                tecnicoLab.setMatricola(matricola);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return tecnicoLab;
    }

    @Override
    public List<TecnicoLab> getAll() throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        String codeSQL = "SELECT * FROM tecnico_lab";
        PreparedStatement statement = conn.prepareStatement(codeSQL);

        ArrayList<TecnicoLab> tecnicoLabList = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery();
        try {
            while (resultSet.next()){
                String nome = resultSet.getString("nome");
                String cognome = resultSet.getString("cognome");
                int matricola = resultSet.getInt("matricola");
                int stipendio = resultSet.getInt("stipendio");
                int telefono = resultSet.getInt("telefono");
                String email = resultSet.getString("email");

                TecnicoLab tecnicoLab = new TecnicoLab(nome, cognome, stipendio, telefono, email);
                tecnicoLab.setMatricola(matricola);
                tecnicoLabList.add(tecnicoLab);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return tecnicoLabList;
    }
    //TODO
    @Override
    public void insert(TecnicoLab tecnicoLab) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "INSERT INTO tecnico_lab(nome, stipendio, telefono, cognome, email) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, tecnicoLab.getNome());
            statement.setInt(2, tecnicoLab.getStipendio());
            statement.setInt(3, tecnicoLab.getTelefono());
            statement.setString(4, tecnicoLab.getCognome());
            statement.setString(5, tecnicoLab.getEmail());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }

    @Override
    public void update(TecnicoLab tecnicoLab) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "UPDATE tecnico_lab SET nome = ?, stipendio = ?, telefono = ?, cognome = ?, email = ?";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, tecnicoLab.getNome());
            statement.setInt(2, tecnicoLab.getStipendio());
            statement.setInt(3, tecnicoLab.getTelefono());
            statement.setString(4, tecnicoLab.getCognome());
            statement.setString(5, tecnicoLab.getEmail());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }
}
