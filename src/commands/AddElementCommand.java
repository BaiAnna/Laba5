package commands;

import collectionClass.Coordinates;
import collectionClass.LocationFrom;
import collectionClass.LocationTo;
import collectionClass.Route;
import dao.*;
import builder.*;

/**
 * Класс команды add наследуется от интерфейса command
 * Добавляет новый элемент в коллекцию
 */

public class AddElementCommand implements InterfaceCommand {
    private InterfaceDao interfaceDao;
    public AddElementCommand(InterfaceDao interfaceDao){
        this.interfaceDao=interfaceDao;

    }

    /**
     *Обработка поступивших параметров, создние и добавление элемента в коллекцию
     * @param object-параметры добавляемого элемента
     * @return
     */
    @Override
    public String execute(Object object)  {
        if (!(object instanceof ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        ArgumentElement argumentElement=(ArgumentElement) object;
        Coordinates coordinates=new Coordinates(argumentElement.coordinatesX, argumentElement.coordinatesY);
        LocationFrom locationFrom=new LocationFrom( argumentElement.fromX, argumentElement.fromY, argumentElement.fromZ, argumentElement.fromName);
        LocationTo locationTo=new LocationTo(argumentElement.toX, argumentElement.toY, argumentElement.toZ);
        Route route=new RouteBuilder().generationId().
                fixName(argumentElement.name).fixCoordinates(coordinates).
                fixLocationFrom(locationFrom).fixLocationTo(locationTo).
                fixDistance(argumentElement.distance).build();
        interfaceDao.create(route);
        return "объект добавлен в коллекцию";


    }
}
