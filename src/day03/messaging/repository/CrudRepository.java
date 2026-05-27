package day03.messaging.repository;

import java.sql.SQLException;
import java.util.List;

public interface CrudRepository<T, ID> {

    //dodanie
    void add(T entity) throws SQLException;

    //pobierz wszystko
    List<T> findAll() throws SQLException;

    //pobierz po id
    T findById(ID id) throws Exception;

    //update
    void update(ID id, T entity) throws Exception;

    //usuń
    void delete(ID id) throws Exception;
}
