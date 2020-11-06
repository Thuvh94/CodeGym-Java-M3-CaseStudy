package service;

import java.sql.SQLException;
import java.util.List;

public interface iService<T> {
    List<T> findAll() throws SQLException, ClassNotFoundException;
    void add(T object) throws SQLException, ClassNotFoundException;
    void update (int id, T object) throws SQLException, ClassNotFoundException;
    void delete(int id) throws SQLException, ClassNotFoundException;
}
