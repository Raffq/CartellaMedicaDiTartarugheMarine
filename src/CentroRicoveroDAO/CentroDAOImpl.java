package CentroRicoveroDAO;

import CentroRicovero.CartellaClinica;
import CentroRicovero.Centro;
import CentroRicovero.UtilityDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CentroDAOImpl implements CentroDAO{
    //TODO
    @Override
    public Centro get(int id) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        Centro centro = null;

        String codeSQL = "SELECT * FROM Centro WHERE id_centro=?";
        PreparedStatement statement = conn.prepareStatement(codeSQL);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        try {
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");


                centro = new Centro(nome);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");

        }
        return centro;
    }
    //TODO
    @Override
    public List<Centro> getAll() throws SQLException {
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
    public void insert(Centro centro) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "INSERT INTO centro(nome) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, centro.getNome());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto durante l'inserimento!");
        }
    }

    @Override
    public void update(Centro centro) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try{
            String codeSQL = "UPDATE centro SET nome = ?";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1,centro.getNome());
            statement.execute();

        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }
}
