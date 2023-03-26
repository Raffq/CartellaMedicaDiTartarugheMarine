package CentroRicoveroDAO;

import CentroRicovero.Operatore;
import CentroRicovero.Personale;
import CentroRicovero.Ricercatore;
import CentroRicovero.UtilityDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RicercatoreDAOImpl extends PersonaleDAOImpl{

    @Override
    public Ricercatore get(int id) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();

        Ricercatore ricercatore = null;

        String codeSQL = "SELECT * FROM ricercatore WHERE matricola = ?";
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

                ricercatore = new Ricercatore(nome, cognome, stipendio, telefono, email);
                ricercatore.setMatricola(matricola);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return ricercatore;
    }
    @Override
    public List<Personale> getAll() throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        String codeSQL = "SELECT * FROM ricercatore";
        PreparedStatement statement = conn.prepareStatement(codeSQL);

        ArrayList<Personale> ricercatoreList = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery();
        try {
            while (resultSet.next()){
                String nome = resultSet.getString("nome");
                String cognome = resultSet.getString("cognome");
                int matricola = resultSet.getInt("matricola");
                int stipendio = resultSet.getInt("stipendio");
                int telefono = resultSet.getInt("telefono");
                String email = resultSet.getString("email");

                Ricercatore ricercatore = new Ricercatore(nome, cognome, stipendio, telefono, email);
                ricercatore.setMatricola(matricola);
                ricercatoreList.add(ricercatore);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return ricercatoreList;
    }

    public void insert(Ricercatore ricercatore) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "INSERT INTO ricercatore(nome, stipendio, telefono, cognome, email) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, ricercatore.getNome());
            statement.setInt(2, ricercatore.getStipendio());
            statement.setInt(3, ricercatore.getTelefono());
            statement.setString(4, ricercatore.getCognome());
            statement.setString(5, ricercatore.getEmail());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }

    public void update(Ricercatore ricercatore) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "UPDATE ricercatore SET nome = ?, stipendio = ?, telefono = ?, cognome = ?, email = ?";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, ricercatore.getNome());
            statement.setInt(2, ricercatore.getStipendio());
            statement.setInt(3, ricercatore.getTelefono());
            statement.setString(4, ricercatore.getCognome());
            statement.setString(5, ricercatore.getEmail());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }
}
