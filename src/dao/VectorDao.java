package dao;

import java.util.List;
import java.util.Vector;
import collectionClass.*;
import com.google.inject.Inject;
import exceptions.ConsoleException;
import others.*;

/**
 * Класс, реализующий интерфейс DAO, для коллекции Vector
 */
public class VectorDao implements InterfaceDao {
    private InterfaceInformationCollection interfaceInformationCollection;
    public VectorDao(){}
    @Inject
    public VectorDao(InterfaceInformationCollection interfaceInformationCollection){
        this.interfaceInformationCollection=interfaceInformationCollection;

    }
    private final List <Route> collection=new Vector<>();

    /**
     * Метод добавляет элемент в коллекцию
     * @param route-элемент, добавляемый в коллекцию
     */
    @Override
    public void create(Route route){
        interfaceInformationCollection.setSize(interfaceInformationCollection.getSize()+1);
        collection.add(route);
    }

    /**
     * Метод обновляет значения элемента
     * @param route-элемент, значения которого обновляется
     * @throws ConsoleException
     */
    @Override
    public void update(Route route) throws ConsoleException {
        Route existedRoute= get(route.getId());
        if (existedRoute!=null){
            existedRoute.setName(route.getName());
            existedRoute.setCoordinate(route.getCoordinate());
            existedRoute.setDistance(route.getDistance());
            existedRoute.setFrom(route.getFrom());
        }
        else{
            throw new ConsoleException("Человек с таким id не существует");
        }
    }

    /**
     * Метод удаляет элемент колллекции по его id
     * @param id-удаляемого элемента
     * @throws ConsoleException
     */
    @Override
    public void delete(Long id) throws ConsoleException {
        Route existedRoute=get(id);
        if (existedRoute!=null){
            collection.remove(existedRoute);
            interfaceInformationCollection.setSize(interfaceInformationCollection.getSize()-1);
        }
        else {
            throw new ConsoleException("Человека с таким id не существует");
        }
    }

    /**
     * Метод возвращает элемент по его id
     * @param id-возвращаемого элемента
     * @return
     */
    @Override
    public Route get(Long id){
        for (Route route: collection){
            if (route.getId()==id){
                return route;
            }
        }
        return null;
    }
    /**
     * Метод возвращает все элементы коллекции
     */
    @Override
    public List<Route> getAll(){
        return collection;
    }

    /**
     * Метод для получения информации о коллекции
     * @return
     */
    public String getInfo(){
        return interfaceInformationCollection.toString();
    }

    /**
     * Метод удаляет все элементы коллекции
     */
    public void deleteAll(){
        collection.clear();
        interfaceInformationCollection.setSize(0);
    }




}

