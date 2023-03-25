package CentroRicoveroDAO;

import CentroRicovero.Componenti;
import CentroRicovero.UtilityDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ComponentiDAOImpl implements ComponentiDAO{

    @Override
    public Componenti get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Componenti> getAll() throws SQLException {
        return null;
    }

    @Override
    public void insert(Componenti componenti) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "INSERT INTO componenti(descrizione) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, componenti.getDescrizione());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto durante l'inserimento!");
        }
    }
//TODO
    @Override
    public void update(Componenti componenti) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try{
            String codeSQL = "UPDATE componenti SET descrizione = ?";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1,componenti.getDescrizione());
            statement.execute();

        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }
}
