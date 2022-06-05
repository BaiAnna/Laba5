package commands;
import java.util.Vector;
import dao.InterfaceDao;
import collectionClass.Route;
import java.util.List;

/**
 * Класс команды filter_less_than_distance наследуется от интерфейса command
 * Выводит элементы, значение поля distance которых меньше заданного
 */
public class FilterLessThanDistanceCommand implements InterfaceCommand{
    private InterfaceDao interfaceDao;
    private List<Route> routes;
    private List<Route> choose=new Vector();
    public FilterLessThanDistanceCommand(InterfaceDao interfaceDao){
        this.interfaceDao=interfaceDao;
    }

    /**
     * Обработка поступивших параметров и поиск элементов, значение поля distance которых меньше заданного
     * @param object-параметры для данной команды
     * @return
     */
    @Override
    public String execute(Object object){
        StringBuilder stringBuilder=new StringBuilder();
        choose.clear();
        if(!(object instanceof  ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        ArgumentDistance argumentDistance=(ArgumentDistance) object;
        routes=interfaceDao.getAll();
        if (routes.isEmpty()){
            return "Коллекция пуста, поэтому элементов, значение distance которых меньше заданного нет";
        }
        for (Route route: routes){
            if (route.getDistance()<argumentDistance.distance){
                choose.add(route);
                stringBuilder.append(route.toString()).append("\n");
            }
        }
        if (choose.size()!=0){
            return stringBuilder.toString();
        }
        else{
            return "Элементов, значение поля distance которых меньше заданного, нет";
        }
    }
}
