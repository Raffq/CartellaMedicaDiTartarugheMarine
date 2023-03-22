package CentroRicovero;

import java.sql.*;

//TODO: non passare gli id nei metodi per fare insert nel database
//TODO: relazionare sede-centro(?)
public class UtilityDatabase {
    static String loginUrl = "jdbc:postgresql://localhost:5432/db_tartarugheMarine";
    static String loginUser = "postgres";
    static String loginPassword = "0000";
    static Connection conn;

    public static Connection getConnection() throws SQLException {
        System.out.println("Connessione al database in corso...");
        try {
            conn = DriverManager.getConnection(loginUrl, loginUser, loginPassword);
            if (conn != null) {
                System.out.println("Connessione al database avvenuta con successo!");
            }
        } catch (SQLException e) {
            System.out.println("OPS! C'è stato un problema durante l'accesso!");
        }
    }

    public void insertIntoTableTartaruga(String valueNome, boolean valuePresente_nel_centro) throws SQLException {
        try {
            String codeSQL = "INSERT INTO tartaruga(nome, id_tartaruga, presente_nel_centro) VALUES (?,default,?)";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, valueNome);
            statement.setString(2, String.valueOf(valuePresente_nel_centro));
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto durante l'inserimento!");
        }
    }

    public void insertIntoTableCentro(String valueNome) throws SQLException {
        try {
            String codeSQL = "INSERT INTO centro(id_centro, nome) VALUES (default,?)";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, valueNome);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto durante l'inserimento!");
        }
    }

    public void insertIntoTableSede(String valueNome, Indirizzo valueIndirizzo, String valueProvincia, String valueCitta, int valueCap) throws SQLException {
        try {
            String codeSQL = "INSERT INTO centro(nome, indirizzo, provincia, citta, cap) VALUES (?,(?,?),?,?,?)";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, valueNome);
            statement.setString(2, valueIndirizzo.getVia());
            statement.setInt(3, valueIndirizzo.getNumero());
            statement.setString(4, valueProvincia);
            statement.setString(5, valueCitta);
            statement.setInt(6, valueCap);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto durante l'inserimento!");
        }
    }
//TODO: attributo id_cartellaclinica e attributo id_tartaruga, targhetta (deve avere l'id del primo accesso (il primo id_tartaruga))(id_tartarga potrà cambiare)
    public void insertIntoTableCartellaClinica(String valueSpecie, int valueLunghezza, int valueLarghezza, int valuePeso, LuogoRitrovamento luogoRitrovamento) throws SQLException {
        try {
            String codeSQL = "INSERT INTO cartella_clinica(specie, lunghezza, larghezza, peso, luogo_ritrovamento) VALUES (?,?,?,?,(?,?,?,?,?,?))";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, valueSpecie);
            statement.setInt(2, valueLunghezza);
            statement.setInt(3, valueLarghezza);
            statement.setInt(4, valuePeso);
            statement.setString(5, luogoRitrovamento.getNome_spiaggia());
            statement.setString(6, luogoRitrovamento.getComune());
            statement.setString(7, luogoRitrovamento.getProvincia());
            statement.setString(8, luogoRitrovamento.getNazione());
            statement.setInt(9, luogoRitrovamento.getLatitudine());
            statement.setInt(10, luogoRitrovamento.getLongitudine());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto durante l'inserimento!");
        }
    }

    //matricola is auto-generated
    public void insertIntoTableVeterinario(String valueNome, String valueCognome, int valueStipendio, int valueTelefono, String valueEmail) throws SQLException {
        try {
            String codeSQL = "INSERT INTO veterinario(nome, cognome, stipendio, telefono, email) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, valueNome);
            statement.setString(2, valueCognome);
            statement.setInt(3, valueStipendio);
            statement.setInt(4, valueTelefono);
            statement.setString(5, valueEmail);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto durante l'inserimento!");
        }
    }

    public void insertIntoTableComponenti(String valueDescrizione) throws SQLException {
        try {
            String codeSQL = "INSERT INTO componenti(descrizione) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(codeSQL);
            statement.setString(1, valueDescrizione);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto durante l'inserimento!");
        }
    }

    public void selectFromTableTartaruga() throws SQLException {

    }

    public void selectFromTableCentro() throws SQLException {

    }

    public void selectFromTableSede() throws SQLException {

    }

    public void selectFromTableCartellaClinica() throws SQLException {

    }

    public void selectFromTableVeterinario() throws SQLException {

    }

    public void selectFromTableComponenti() throws SQLException {

    }
}