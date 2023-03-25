package CentroRicoveroDAO;

import CentroRicovero.Personale;
import CentroRicovero.Operatore;
import CentroRicovero.UtilityDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OperatoreDAOImpl implements OperatoreDAO {

    @Override
    public Operatore get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Operatore> getAll() throws SQLException {
        return null;
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
            System.out.println("Qualcosa è andato storto durante l'inserimento!");
        }
    }
//TODO
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
