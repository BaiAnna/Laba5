package commands;

import collectionClass.Route;
import dao.InterfaceDao;
import exceptions.ConsoleException;
import others.InterfaceInformationCollection;
import java.util.List;
/**
 * Класс для команды remove_by_id наследуется от интерфейса command
 * Удаляет элемент из коллекции по его id
 */
public class RemoveByIdCommand implements InterfaceCommand{
    private List<Route> routes;
    private InterfaceDao interfaceDao;
    private InterfaceInformationCollection interfaceInformationCollection;
    public RemoveByIdCommand(InterfaceDao interfaceDao, InterfaceInformationCollection interfaceInformationCollection){
        this.interfaceDao=interfaceDao;
        this.interfaceInformationCollection=interfaceInformationCollection;
    }

    /**
     * Обработка поступивших параметров, поиск элемента, id которого равно задаанному, и его удаление
     * @param object-параметры для данной команды
     * @return
     */
    @Override
    public String execute(Object object){
        if (!(object instanceof ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        ArgumentId argumentId=(ArgumentId) object;
        if (interfaceInformationCollection.getSize()==0){
            return "Коллекция пуста";
        }
        int count=0;
        routes=interfaceDao.getAll();
        for (Route route:routes){
            if (argumentId.id== route.getId()){
                count++;
            }
        }
        if (count==1){
            try{
                interfaceDao.delete(argumentId.id);
                return "Элемент, соответствующий даннаму id, успешно удален";
            }
            catch (ConsoleException exception){
                return "Человека с таким id не существует";
            }
        }
        else{
            return "Невозможно удвлить элемент, соответствующего данному id, так как в коллекции несколько элементов с таким id";
        }

    }
}
