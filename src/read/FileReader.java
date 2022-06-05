package read;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.FileWriter;
import others.*;

/**
 * Класс для чтения данных из файла
 */
public class FileReader implements InterfaceRead {
    private String fileName;
    private InformationCollectionRoute informationCollectionRoute;
    private BuildCollectionRouteVector buildCollection;

    public FileReader(String arg, BuildCollectionRouteVector buildCollection){
        this.buildCollection=buildCollection;
        this.fileName=arg;

    }

    /**
     * Метод читает данные из файла и добавляет в коллекцию
     * @return
     */
    @Override
    public String read() {
        String line;
        Path path= Paths.get(fileName);

        try{
            Scanner scanner = new Scanner(path);
            while(scanner.hasNext()){
                line=scanner.next();
                buildCollection.dateConversion(line);
            }
            scanner.close();
        } catch(NoSuchFileException e){
            System.out.println("Такого файла нет");
        }
        catch (IOException e) {
            System.out.println("Что-то пошло не так");
        }
        return null;
    }


}
