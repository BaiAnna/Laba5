package others;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import collectionClass.*;

/**
 * Класс для записи данных в файл формата csv
 */
public class FileWrite implements InterfaceWrite{
    private String filename;
    public FileWrite(String filename){
        this.filename=filename;
    }

    /**
     * Метод записывает данные в файл с расширением csv
     * @param route-элемент, который записываем в файл
     * @return
     */
    @Override
    public String writer(Route route)  {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename, true);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            StringBuilder stringBuilder=new StringBuilder();
            stringBuilder.append("\n").append(route.getId()).append(",");
            stringBuilder.append(route.getName()).append(",");
            stringBuilder.append(route.getCoordinate().getX()).append(",");
            stringBuilder.append(route.getCoordinate().getY()).append(",");
            stringBuilder.append(route.getLocalDate()).append(",");
            stringBuilder.append(route.getFrom().getX()).append(",");
            stringBuilder.append(route.getFrom().getY()).append(",");
            stringBuilder.append(route.getFrom().getZ()).append(",");
            stringBuilder.append(route.getFrom().getName()).append(",");
            stringBuilder.append(route.getTo().getX()).append(",");
            stringBuilder.append(route.getTo().getY()).append(",");
            stringBuilder.append(route.getTo().getZ()).append(",");
            stringBuilder.append(route.getDistance());
            String text=stringBuilder.toString();
            byte[] buffer=text.getBytes();
            bufferedOutputStream.write(buffer);
            bufferedOutputStream.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Такого файла не найдена");
        }catch(IOException exception){

        }
        return "";
    }
}
