package dao;

import java.util.List;

import collectionClass.Route;
import exceptions.ConsoleException;

public interface InterfaceDao {
    void create(Route route);

    void update(Route route) throws ConsoleException;

    void delete(Long id) throws ConsoleException;

    Route get(Long id);

    List<Route> getAll();
    String getInfo();
    void deleteAll();


}
