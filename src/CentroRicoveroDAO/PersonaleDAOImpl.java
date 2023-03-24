package CentroRicoveroDAO;

import CentroRicovero.Operatore;
import CentroRicovero.Personale;
import CentroRicovero.UtilityDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PersonaleDAOImpl implements PersonaleDAO{
    @Override
    public Personale get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Personale> getAll() throws SQLException {
        return null;
    }

    @Override
    public void insert(Personale personale) throws SQLException {
        Connection conn = UtilityDatabase.getConnection();
        try {
            String codeSQL = "INSERT INTO personale(nome, stipendio, telefono, cognome, email) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, personale.getNome());
            statement.setInt(2, personale.getStipendio());
            statement.setInt(3, personale.getTelefono());
            statement.setString(4, personale.getCognome());
            statement.setString(5, personale.getEmail());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto durante l'inserimento!");
        }
    }
//TODO
    @Override
    public void update(Personale personale) throws SQLException {
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
