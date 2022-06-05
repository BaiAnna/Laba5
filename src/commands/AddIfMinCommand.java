package commands;

import builder.RouteBuilder;
import collectionClass.Coordinates;
import collectionClass.LocationFrom;
import collectionClass.LocationTo;
import collectionClass.Route;
import dao.InterfaceDao;
import java.util.Collections;
import java.util.List;

/**
 * Класс команды add_if_min наследуется от интерфейса command
 * Класс для добавления элемента в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
 */

public class AddIfMinCommand implements InterfaceCommand{
    private InterfaceDao interfaceDao;
    private List<Route> routes;
    public AddIfMinCommand(InterfaceDao interfaceDao){
        this.interfaceDao=interfaceDao;
    }

    /**
     * Обработка поступивших парметров, создание и добавление элемента в коллекцию
     * @param object-параметрв добавляемого элемента
     * @return
     */
    @Override
    public String execute(Object object){
        if (!(object instanceof ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        ArgumentElement argumentElement=(ArgumentElement) object;
        Coordinates coordinates=new Coordinates(argumentElement.coordinatesX, argumentElement.coordinatesY);
        LocationFrom locationFrom=new LocationFrom(argumentElement.fromX, argumentElement.fromY, argumentElement.fromZ, argumentElement.name);
        LocationTo locationTo=new LocationTo(argumentElement.toX, argumentElement.toY, argumentElement.toZ);
        Route route=new RouteBuilder().generationId().fixName(argumentElement.name).
                fixCoordinates(coordinates).
                fixLocationFrom(locationFrom).
                fixLocationTo(locationTo).
                fixDistance(argumentElement.distance).build();
        routes=interfaceDao.getAll();
        Collections.sort(routes);
        if (routes.isEmpty()){
            return "Коллекция пуста, поэтому невозможно выполнить данную команду";
        }
        if(route.compareTo(routes.iterator().next())<0){
            interfaceDao.create(route);
            return "Объект успешно добавлен в коллекцию";
        }
        else{
            return "значение данного элемента не меньше, чем у наименьшего элемента коллекции, поэтому его не возможно добавить в коллекцию";
        }

    }

}
