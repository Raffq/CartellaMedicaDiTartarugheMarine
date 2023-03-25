package CentroRicoveroDAO;

import CentroRicovero.Centro;
import CentroRicovero.Personale;
import CentroRicovero.Operatore;
import CentroRicovero.UtilityDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperatoreDAOImpl implements OperatoreDAO {

    @Override
    public Operatore get(int id) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();

        Operatore operatore = null;

        String codeSQL = "SELECT * FROM operatore WHERE matricola = ?";
        PreparedStatement statement = conn.prepareStatement(codeSQL);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        try {
            if (resultSet.next()){
                String nome = resultSet.getString("nome");
                String cognome = resultSet.getString("cognome");
                int matricola = resultSet.getInt("matricola");
                int stipendio = resultSet.getInt("stipendio");
                int telefono = resultSet.getInt("telefono");
                String email = resultSet.getString("email");

                operatore = new Operatore(nome, cognome, stipendio, telefono, email);
                operatore.setMatricola(matricola);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return operatore;
    }

    @Override
    public List<Operatore> getAll() throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        String codeSQL = "SELECT * FROM operatore";
        PreparedStatement statement = conn.prepareStatement(codeSQL);

        ArrayList<Operatore> operatoreList = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery();
        try {
            while (resultSet.next()){
                String nome = resultSet.getString("nome");
                String cognome = resultSet.getString("cognome");
                int matricola = resultSet.getInt("matricola");
                int stipendio = resultSet.getInt("stipendio");
                int telefono = resultSet.getInt("telefono");
                String email = resultSet.getString("email");

                Operatore operatore = new Operatore(nome, cognome, stipendio, telefono, email);
                operatore.setMatricola(matricola);
                operatoreList.add(operatore);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return operatoreList;
    }

    @Override
    public void insert(Operatore operatore) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "INSERT INTO operatore(nome, stipendio, telefono, cognome, email) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, operatore.getNome());
            statement.setInt(2, operatore.getStipendio());
            statement.setInt(3, operatore.getTelefono());
            statement.setString(4, operatore.getCognome());
            statement.setString(5, operatore.getEmail());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }
    @Override
    public void update(Operatore operatore) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try{
            String codeSQL = "UPDATE operatore SET nome = ?, stipendio = ?, telefono = ?, cognome = ?, email = ?";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, operatore.getNome());
            statement.setInt(2, operatore.getStipendio());
            statement.setInt(3, operatore.getTelefono());
            statement.setString(4, operatore.getCognome());
            statement.setString(5, operatore.getEmail());
            statement.execute();

        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }
}
