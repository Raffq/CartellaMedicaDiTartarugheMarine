package CentroRicoveroDAO;

import CentroRicovero.Ricercatore;
import CentroRicovero.UtilityDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RicercatoreDAOImpl implements RicercatoreDAO{

    @Override
    public Ricercatore get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Ricercatore> getAll() throws SQLException {
        return null;
    }

    @Override
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
            System.out.println("Qualcosa è andato storto durante l'inserimento!");
        }
    }

    @Override
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
            System.out.println("Qualcosa è andato storto durante l'inserimento!");
        }
    }
}
