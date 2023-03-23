package CentroRicoveroDAO;

import CentroRicovero.CartellaClinica;
import CentroRicovero.UtilityDatabase;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;

public class CartellaClinicaDAOImpl implements CartellaClinicaDAO {
    //TODO:
    @Override
    public CartellaClinica get(int id) throws SQLException {
        //try {
            Connection conn = UtilityDatabase.getConnection();
            CartellaClinica cartellaClinica = null;

            String codeSQL = "SELECT * FROM cartella_clinica WHERE id_cartella=?";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                try {
                    String specie = resultSet.getString("specie");
                    int lunghezza = resultSet.getInt("lunghezza");
                    int larghezza = resultSet.getInt("larghezza");
                    int peso = resultSet.getInt("peso");
                    String luogoRitrovamento = resultSet.getString("luogo_ritrovamento");

                    cartellaClinica = new CartellaClinica(specie, lunghezza, larghezza, peso, luogoRitrovamento);
                } catch (SQLException e) {
                    System.out.println("Qualcosa è andato storto!");
                }

            }
        return cartellaClinica;
    }

    @Override
    public List getAll() throws SQLException {
        return null;
    }

    @Override
    public void save(CartellaClinica cartellaClinica) throws SQLException {
    }

    @Override
    public void insert(CartellaClinica cartellaClinica) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "INSERT INTO cartella_clinica(specie, lunghezza, larghezza, peso, luogo_ritrovamento) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, cartellaClinica.getSpecie());
            statement.setInt(2, cartellaClinica.getLunghezza());
            statement.setInt(3, cartellaClinica.getLarghezza());
            statement.setInt(4, cartellaClinica.getPeso());
            statement.setString(5, cartellaClinica.getLuogoRitrovamento());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto durante l'inserimento!");
        }
    }

    @Override
    public void update(CartellaClinica cartellaClinica) throws SQLException {
    }

    @Override
    public void delete(CartellaClinica cartellaClinica) throws SQLException {
    }
}
