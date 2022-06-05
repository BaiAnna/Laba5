package commands;

import builder.RouteBuilder;
import collectionClass.Coordinates;
import collectionClass.LocationFrom;
import collectionClass.LocationTo;
import dao.InterfaceDao;
import exceptions.ConsoleException;
import others.InterfaceInformationCollection;
import collectionClass.Route;
import java.util.List;

/**
 * Класс для команды update наследуется от интерфейса command
 * Обновляет значение элемента коллекции, id которого равен заданному
 */
public class UpdateIdElementCommand implements InterfaceCommand{
    private InterfaceDao interfaceDao;
    private List<Route> routes;
    public UpdateIdElementCommand(InterfaceDao interfaceDao){
        this.interfaceDao=interfaceDao;
    }

    /**
     * Обработка поступивших параметров, поиск элемента, id которого равно заданному, и обновление его значений
     * @param object-параметры для данной команды
     * @return
     */
    @Override
    public String execute(Object object) {
        if(!(object instanceof ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        routes=interfaceDao.getAll();
        if (interfaceDao.getAll().isEmpty()){
            return "Коллекция пуста, поэтому обновить элемент невозможно";
        }
        ArgumentUpdate argumentUpdate=(ArgumentUpdate) object;
        int count=0;
        for (Route route:routes){
            if (argumentUpdate.id== route.getId()){
                count++;
            }
        }
        if (count==1){
            try {
                Route route=new RouteBuilder().fixId(argumentUpdate.id).fixName(argumentUpdate.name).
                        fixCoordinates(new Coordinates(argumentUpdate.coordinatesX, argumentUpdate.coordinatesY)).
                        fixLocationFrom(new LocationFrom(argumentUpdate.fromX, argumentUpdate.fromY, argumentUpdate.fromZ, argumentUpdate.fromName)).
                        fixLocationTo(new LocationTo(argumentUpdate.toX, argumentUpdate.toY, argumentUpdate.toZ )).
                        fixDistance(argumentUpdate.distance).build();
                interfaceDao.update(route);
                return "Элемент, соответствующий данному id, обновлен";
            } catch(ConsoleException e){
                return "Человека с таким id не существует";
            }
        }
        else{
            return "Нвозможно обновить значение элемента, соответствующего данному id, так как в коллекции несколько элементов с таким id";
        }
    }
}
