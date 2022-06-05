package commands;
import collectionClass.Route;
import dao.InterfaceDao;
import exceptions.ConsoleException;

import java.util.Collections;
import java.util.List;

/**
 * Класс для команды remove_first наследуется от интерфейса command
 * Удаляет первый элемент из коллекции
 */
public class RemoveFirstCommand implements InterfaceCommand {
    private InterfaceDao interfaceDao;
    private List<Route> routes;

    public RemoveFirstCommand(InterfaceDao interfaceDao) {
        this.interfaceDao = interfaceDao;
    }

    /**
     * Обработка поступивших параметров, поиск первого элемента и его удаление
     * @param object-параметры для данной команды
     * @return
     */

    @Override
    public String execute(Object object){
        if (!(object instanceof ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        String removeFirst;
        routes = interfaceDao.getAll();
        if (routes.isEmpty()){
            return "Коллекция пуста, поэтому удалять нечего";
        }
        try {
            Collections.sort(routes);
            interfaceDao.delete(routes.iterator().next().getId());
            removeFirst = "Первый элемент коллекции успешно удален";
        }catch(ConsoleException exception){
            removeFirst = "Коллекция пуста, поэтому первый элемент коллекции удалить невозможно";
            }
        return removeFirst;
    }
}
