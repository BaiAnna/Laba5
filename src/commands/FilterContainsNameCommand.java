package commands;
import collectionClass.Route;
import dao.InterfaceDao;
import java.util.Vector;
import java.util.List;

/**
 * Класс команды filter_contains_name наследуется от интерфейса command
 * Выводит элементы, значение поля name которых содержит заданную подстроку
 */

public class FilterContainsNameCommand implements InterfaceCommand{
    private InterfaceDao interfaceDao;
    public FilterContainsNameCommand(InterfaceDao interfaceDao){
        this.interfaceDao=interfaceDao;
    }
    private List<Route> routes;
    private List<Route> choose= new Vector();

    /**
     * Обработка поступивших данных и поиск элементов, name которых содержит заданную подстроку
     * @param object-параметры для данной команды
     * @return
     */
    @Override
    public String execute(Object object) {
        StringBuilder stringBuilder=new StringBuilder();
        choose.clear();
        if(!(object instanceof ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        routes = interfaceDao.getAll();
        if (routes.isEmpty()){
            return "Коллекция пуста, поэтому элементов, содержащих данную пожстроку, нет";
        }
        ArgumentName argumentName = (ArgumentName) object;
        for (Route route : routes) {
            if (route.getName().contains(argumentName.name)) {
                stringBuilder.append(route.toString()).append("\n");
            }
        }
        if (choose.size()!=0){
            return stringBuilder.toString();
        }
        else{
            return "Элементов, содержащих заданную подстроку, нет" ;
        }
    }

}
