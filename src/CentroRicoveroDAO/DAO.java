package CentroRicoveroDAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    T get(int id) throws SQLException;
    List<T> getAll() throws SQLException;
    int save() throws SQLException;
    int insert() throws SQLException;
    int update() throws SQLException;
    int delete() throws SQLException;
}
