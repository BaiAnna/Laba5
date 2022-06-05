package read;

import java.util.*;

/**
 * Класс для чтения данных с консоли
 */
public class ConsoleReader implements InterfaceRead {
    /**
     * Метод для чтения данных с консоли
     * @return
     */
    @Override
    public String read(){
        Scanner scanner= new Scanner(System.in);
        String input=scanner.nextLine().trim();
        return input;
    }

}
