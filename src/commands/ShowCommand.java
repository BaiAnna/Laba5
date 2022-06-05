package commands;

import collectionClass.Route;

import java.util.List;
import dao.*;

/**
 * Класс для команды show наследуется от интерфейса command
 * Выводит в стандартный поток вывода все элементы коллекции в строковом представлении
 */
public class ShowCommand implements InterfaceCommand {
    private InterfaceDao interfaceDao;
    public ShowCommand(InterfaceDao interfaceDao){
        this.interfaceDao=interfaceDao;
    }

    /**
     * Обработка поступивших параметров и получение всех элементов коллекции
     * @param object-параметры для данной команды
     * @return
     */
    @Override
    public String execute(Object object) {
        if(!(object instanceof ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        List<Route> routes= interfaceDao.getAll();
        StringBuilder stringBuilder=new StringBuilder();
        if (routes.isEmpty()){
            return "Коллекция пуста, поэтому элементы коллекции не могут быть выведены";
        }
        else{
            for (Route route: routes){
                stringBuilder.append(route.toString()).append("\n");
            }
            return stringBuilder.toString();

        }
    }

}

