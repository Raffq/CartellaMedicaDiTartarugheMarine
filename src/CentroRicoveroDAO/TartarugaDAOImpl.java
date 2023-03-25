package CentroRicoveroDAO;

import CentroRicovero.Operatore;
import CentroRicovero.Personale;
import CentroRicovero.Tartaruga;
import CentroRicovero.UtilityDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TartarugaDAOImpl implements TartarugaDAO{
    @Override
    public Tartaruga get(int id) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();

        Tartaruga tartaruga = null;

        String codeSQL = "SELECT * FROM tartaruga WHERE id_tartaruga = ?";
        PreparedStatement statement = conn.prepareStatement(codeSQL);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        try {
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                boolean presente_nel_centro = resultSet.getBoolean("presente_nel_centro");
                int targhetta = resultSet.getInt("targhetta");

                tartaruga = new Tartaruga(nome);
                tartaruga.setId_tartaruga(id);
                tartaruga.setTarghetta(targhetta);
                tartaruga.setPresente_nel_centro(presente_nel_centro);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return tartaruga;
    }

    @Override
    public List<Tartaruga> getAll() throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        String codeSQL = "SELECT * FROM tartaruga";
        PreparedStatement statement = conn.prepareStatement(codeSQL);

        ArrayList<Tartaruga> tartarugaList = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery();
        try {
            while (resultSet.next()){
                String nome = resultSet.getString("nome");
                int id_tartaruga = resultSet.getInt("id_tartaruga");
                boolean presente_nel_centro = resultSet.getBoolean("presente_nel_centro");
                int targhetta = resultSet.getInt("targhetta");

                Tartaruga tartaruga = new Tartaruga(nome);
                tartaruga.setPresente_nel_centro(presente_nel_centro);
                tartaruga.setId_tartaruga(id_tartaruga);
                tartaruga.setTarghetta(targhetta);
                tartarugaList.add(tartaruga);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto");
        }
        return tartarugaList;
    }

    @Override
    public void insert(Tartaruga tartaruga) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "INSERT INTO tartaruga(nome, presente_nel_centro, targhetta) VALUES (?,?,currval('tartaruga_id_tartaruga_seq'::regclass))";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, tartaruga.getNome());
            statement.setBoolean(2, tartaruga.isPresente_nel_centro());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }

    @Override
    public void update(Tartaruga tartaruga) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "UPDATE tartaruga SET nome = ?, presente_nel_centro = ?";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, tartaruga.getNome());
            statement.setBoolean(2, tartaruga.isPresente_nel_centro());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }

    @Override
    public void updateId(Tartaruga tartaruga) throws SQLException{
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "UPDATE tartaruga SET id_tartaruga = nextval('tartaruga_id_tartaruga_seq'::regclass) WHERE id_tartaruga = ?";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setInt(1, tartaruga.getId_tartaruga());
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }
}
