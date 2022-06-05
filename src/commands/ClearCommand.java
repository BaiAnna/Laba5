package commands;

import dao.InterfaceDao;
import others.InterfaceInformationCollection;

/**
 * Класс команды clear наследуется от интерфейса command
 * Удаляет все элементы коллекции
 */

public class ClearCommand implements InterfaceCommand{
    private InterfaceDao interfaceDao;
    public ClearCommand(InterfaceDao interfaceDao){
        this.interfaceDao=interfaceDao;
    }

    /**
     * Обработка поступивших параметров и "очистка" коллекции
     * @param object-параметры для данной команды
     * @return
     */
    @Override
    public String execute(Object object){
        if (!(object instanceof  ArgumentInterface)) {
            return "Невозможно выполнить данную команду";
        }
        if (interfaceDao.getAll().isEmpty()){
            return "Коллекция пуста";
        }
        else{
            interfaceDao.deleteAll();
            return "Коллекия очищена";
        }

    }
}
