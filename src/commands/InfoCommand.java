package commands;
import dao.*;
import others.InterfaceInformationCollection;

/**
 * Класс команды info наследуется от интерфейса command
 * Выводит в стандартный поток вывода информацию о коллекции
 */
public class InfoCommand implements InterfaceCommand {
    private InterfaceDao interfaceDao;
    private InterfaceInformationCollection interfaceInformationCollection;
    public InfoCommand(InterfaceDao interfaceDao, InterfaceInformationCollection interfaceInformationCollection) {
        this.interfaceInformationCollection=interfaceInformationCollection;
        this.interfaceDao = interfaceDao;
    }

    /**
     * Обработка поступивших параметров и и получение информации о коллекции
     * @param object-параметры для данной команды
     * @return
     */
    @Override
    public String execute(Object object){
        if (!(object instanceof  ArgumentInterface)){
            return "Невозможно выполнить данную команду";
        }
        String info;
        if (interfaceInformationCollection.getSize()==0){
            info="Коллекция пуста, поэтому информация о коллекции не может быть выведена";
        }
        else{
            info=interfaceDao.getInfo();
        }
        return info;
    }
}
