package CentroRicoveroDAO;

import CentroRicovero.Tartaruga;
import CentroRicovero.UtilityDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TartarugaDAOImpl implements TartarugaDAO{
    @Override
    public Tartaruga get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Tartaruga> getAll() throws SQLException {
        return null;
    }

    @Override
    public void insert(Tartaruga tartaruga) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "INSERT INTO tartaruga(nome, presente_nel_centro, targhetta) VALUES (?,?,?)";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, tartaruga.getNome());
            statement.setBoolean(2, tartaruga.isPresente_nel_centro());
            statement.setInt(3, tartaruga.getTarghetta());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto durante l'inserimento!");
        }
    }

    @Override
    public void update(Tartaruga tartaruga) throws SQLException {

    }
}
