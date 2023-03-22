package CentroRicoveroDAO;

import CentroRicovero.CartellaClinica;
import CentroRicovero.LuogoRitrovamento;
import CentroRicovero.UtilityDatabase;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;

public class CartellaClinicaDAOImpl implements CartellaClinicaDAO{
    //TODO:
    @Override
    public CartellaClinica get(int id) throws SQLException {
        try {
            Connection conn = UtilityDatabase.getConnection();
            //TODO: risolvere! Non so ancora come convertire un tipo sql in oggetto java
            PGConnection pgConn = conn.unwrap();
            CartellaClinica cartellaClinica = null;
            String codeSQL = "SELECT * FROM cartella_clinica WHERE id_cartella=?";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String specie = resultSet.getString("specie");
                int lunghezza = resultSet.getInt("lunghezza");
                int larghezza = resultSet.getInt("larghezza");
                int peso = resultSet.getInt("peso");
                LuogoRitrovamento luogoRitrovamento = (LuogoRitrovamento) resultSet.getObject("luogo_ritrovamento");

            }
        } catch (SQLException e) {

        }
    }

    @Override
    public List getAll() throws SQLException {
        return null;
    }

    @Override
    public int save() throws SQLException {
        return 0;
    }

    @Override
    public int insert() throws SQLException {
        return 0;
    }

    @Override
    public int update() throws SQLException {
        return 0;
    }

    @Override
    public int delete() throws SQLException {
        return 0;
    }
}
