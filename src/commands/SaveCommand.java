package commands;

import dao.InterfaceDao;
import others.BuildCollectionRouteVector;
import others.InterfaceWrite;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.List;
import collectionClass.*;
import read.InterfaceRead;

/**
 * Класс для команды save наследуется от интерфейса command
 * Сохраняет коллекцию в файл
 */
public class SaveCommand implements InterfaceCommand{
    private InterfaceWrite interfaceWrite;
    private InterfaceDao interfaceDao;
    private String fileName;
    public SaveCommand(InterfaceWrite interfaceWrite, InterfaceDao interfaceDao, String arg){
        this.interfaceWrite=interfaceWrite;
        this.interfaceDao=interfaceDao;
        this.fileName=arg;
    }
    private List <Route> r=new Vector<>();

    /**
     * Обработка поступивших параметров и сохранение элементов коллекции в файл
     * @param object-параметры для данной команды
     * @return
     */
    @Override
    public String execute(Object object) {
        if (!(object instanceof ArgumentInterface)) {
            return "Невозможно выполнить данную команду";
        }
        r = interfaceDao.getAll();
        String save;
        try {
            new FileWriter(fileName, false).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (r.isEmpty()) {
            save = "Коллекция пуста,поэтому сохранять нечего";
        } else {
            for (Route route : r) {
                interfaceWrite.writer(route);
                }
            save = "коллекция сохранена в файл";
        }
        return save;
    }

}
