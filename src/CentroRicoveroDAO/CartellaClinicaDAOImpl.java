package CentroRicoveroDAO;

import CentroRicovero.CartellaClinica;
import CentroRicovero.UtilityDatabase;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CartellaClinicaDAOImpl implements CartellaClinicaDAO {
    @Override
    public CartellaClinica get(int id) throws SQLException {
            Connection conn = UtilityDatabase.getConnection();
            CartellaClinica cartellaClinica = null;

            String codeSQL = "SELECT * FROM cartella_clinica WHERE id_cartella=?";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            try {
                    if (resultSet.next()) {
                         String specie = resultSet.getString("specie");
                         int lunghezza = resultSet.getInt("lunghezza");
                         int larghezza = resultSet.getInt("larghezza");
                         int peso = resultSet.getInt("peso");
                         String luogoRitrovamento = resultSet.getString("luogo_ritrovamento");
                         cartellaClinica = new CartellaClinica(specie, lunghezza, larghezza, peso, luogoRitrovamento);
                }
            } catch (SQLException e) {
                System.out.println("Qualcosa è andato storto!");

            }
        return cartellaClinica;
    }

    @Override
    public List<CartellaClinica> getAll() throws SQLException {
            Connection conn = UtilityDatabase.getConnection();
            String codeSQL = "SELECT * FROM cartella_clinica";
            PreparedStatement statement = conn.prepareStatement(codeSQL);

            ArrayList<CartellaClinica> cartellaClinicaList = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery();
            try {
            while (resultSet.next()){
                String specie = resultSet.getString("specie");
                int lunghezza = resultSet.getInt("lunghezza");
                int larghezza = resultSet.getInt("larghezza");
                int peso = resultSet.getInt("peso");
                String luogoRitrovamento = resultSet.getString("luogo_ritrovamento");

                CartellaClinica cartellaClinica = new CartellaClinica(specie, lunghezza, larghezza, peso, luogoRitrovamento);
                cartellaClinicaList.add(cartellaClinica);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto");
        }
            return cartellaClinicaList;
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
//TODO
    @Override
    public void update(CartellaClinica cartellaClinica) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try{
            String codeSQL = "UPDATE cartella_clinica SET specie = ?, lunghezza = ?, peso = ?, luogo_ritrovamento = ?";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1,cartellaClinica.getSpecie());
            statement.setInt(2,cartellaClinica.getLunghezza());
            statement.setInt(3,cartellaClinica.getLarghezza());
            statement.setInt(4,cartellaClinica.getPeso());
            statement.setString(5,cartellaClinica.getLuogoRitrovamento());
            statement.execute();

        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }

}
