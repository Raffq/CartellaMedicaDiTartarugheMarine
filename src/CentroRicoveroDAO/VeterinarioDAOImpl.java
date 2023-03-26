package CentroRicoveroDAO;

import CentroRicovero.Personale;
import CentroRicovero.UtilityDatabase;
import CentroRicovero.Veterinario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeterinarioDAOImpl extends PersonaleDAOImpl{

    @Override
    public Veterinario get(int id) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();

        Veterinario veterinario = null;

        String codeSQL = "SELECT * FROM veterinario WHERE matricola = ?";
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

                veterinario = new Veterinario(nome, cognome, stipendio, telefono, email);
                veterinario.setMatricola(matricola);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return veterinario;
    }

    @Override
    public List<Personale> getAll() throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        String codeSQL = "SELECT * FROM veterinario";
        PreparedStatement statement = conn.prepareStatement(codeSQL);

        ArrayList<Personale> veterinarioList = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery();
        try {
            while (resultSet.next()){
                String nome = resultSet.getString("nome");
                String cognome = resultSet.getString("cognome");
                int matricola = resultSet.getInt("matricola");
                int stipendio = resultSet.getInt("stipendio");
                int telefono = resultSet.getInt("telefono");
                String email = resultSet.getString("email");

                Veterinario veterinario = new Veterinario(nome, cognome, stipendio, telefono, email);
                veterinario.setMatricola(matricola);
                veterinarioList.add(veterinario);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return veterinarioList;
    }


    public void insert(Veterinario veterinario) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "INSERT INTO veterinario(nome, stipendio, telefono, cognome, email) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, veterinario.getNome());
            statement.setInt(2, veterinario.getStipendio());
            statement.setInt(3, veterinario.getTelefono());
            statement.setString(4, veterinario.getCognome());
            statement.setString(5, veterinario.getEmail());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }

    public void update(Veterinario veterinario) throws SQLException {
        try {
            Connection conn = UtilityDatabase.getConnection();
            String codeSQL = "UPDATE veterinario SET nome = ?, stipendio = ?, telefono = ?, cognome = ?, email = ?";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, veterinario.getNome());
            statement.setInt(2, veterinario.getStipendio());
            statement.setInt(3, veterinario.getTelefono());
            statement.setString(4, veterinario.getCognome());
            statement.setString(5, veterinario.getEmail());
            statement.execute();
        } catch (SQLException e)  {
            System.out.println("Qualcosa è andato storto!");
        }
    }
}
