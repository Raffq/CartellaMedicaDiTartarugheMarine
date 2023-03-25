package CentroRicoveroDAO;

import CentroRicovero.TecnicoLab;
import CentroRicovero.UtilityDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TecnicoLabDAOImpl implements TecnicoLabDAO{
    @Override
    public TecnicoLab get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<TecnicoLab> getAll() throws SQLException {
        return null;
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
            System.out.println("Qualcosa è andato storto durante l'inserimento!");
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
            System.out.println("Qualcosa è andato storto durante l'inserimento!");
        }
    }
}
