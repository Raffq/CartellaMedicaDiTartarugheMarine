package CentroRicoveroDAO;

import CentroRicovero.Centro;
import CentroRicovero.Operatore;
import CentroRicovero.Personale;
import CentroRicovero.UtilityDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaleDAOImpl implements PersonaleDAO{
    @Override
    public Personale get(int id) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();

        Personale personale = null;

        String codeSQL = "SELECT * FROM personale WHERE matricola = ?";
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

                personale = new Operatore(nome, cognome, stipendio, telefono, email);
                personale.setMatricola(matricola);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return personale;
    }

    @Override
    public List<Personale> getAll() throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        String codeSQL = "SELECT * FROM personale";
        PreparedStatement statement = conn.prepareStatement(codeSQL);

        ArrayList<Personale> personaleList = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery();
        try {
            while (resultSet.next()){
                String nome = resultSet.getString("nome");
                String cognome = resultSet.getString("cognome");
                int matricola = resultSet.getInt("matricola");
                int stipendio = resultSet.getInt("stipendio");
                int telefono = resultSet.getInt("telefono");
                String email = resultSet.getString("email");

                Personale personale = new Personale(nome, cognome, stipendio, telefono, email);
                personale.setMatricola(matricola);
                personaleList.add(personale);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return personaleList;
    }

    @Override
    public void insert(Personale personale) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "INSERT INTO personale(nome, stipendio, telefono, cognome, email) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, personale.getNome());
            statement.setInt(2, personale.getStipendio());
            statement.setInt(3, personale.getTelefono());
            statement.setString(4, personale.getCognome());
            statement.setString(5, personale.getEmail());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }
//TODO
    @Override
    public void update(Personale personale) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try{
            String codeSQL = "UPDATE personale SET nome = ?, stipendio = ?, telefono = ?, cognome = ?, email = ?";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, personale.getNome());
            statement.setInt(2, personale.getStipendio());
            statement.setInt(3, personale.getTelefono());
            statement.setString(4, personale.getCognome());
            statement.setString(5, personale.getEmail());
            statement.execute();

        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }
}
