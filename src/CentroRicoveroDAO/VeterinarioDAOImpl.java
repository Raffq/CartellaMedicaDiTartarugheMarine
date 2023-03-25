package CentroRicoveroDAO;

import CentroRicovero.UtilityDatabase;
import CentroRicovero.Veterinario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class VeterinarioDAOImpl implements VeterinarioDAO{

    @Override
    public Veterinario get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Veterinario> getAll() throws SQLException {
        return null;
    }

    @Override
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
            System.out.println("Qualcosa è andato storto durante l'inserimento!");
        }
    }

    @Override
    public void update(Veterinario veterinario) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        String codeSQL = "UPDATE veterinario SET nome = ?, stipendio = ?, telefono = ?, cognome = ?, email = ?";
        PreparedStatement statement = conn.prepareStatement(codeSQL);
        statement.setString(1, veterinario.getNome());
        statement.setInt(2, veterinario.getStipendio());
        statement.setInt(3, veterinario.getTelefono());
        statement.setString(4, veterinario.getCognome());
        statement.setString(5, veterinario.getEmail());
        statement.execute();
    }
}
