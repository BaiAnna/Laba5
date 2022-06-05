package others;

import commands.Executor;
import read.InterfaceRead;
import exceptions.*;
/**
 * Класс для считавания параметров и название команд с кносоли, чтобы выполнить команды
 */
public class ReadDataConsole {
    private InterfaceRead interfaceRead;
    private Executor executor;
    public ReadDataConsole(InterfaceRead interfaceRead, Executor executor){
        this.interfaceRead=interfaceRead;
        this.executor=executor;
    }

    /**
     * Метод для корректнго считывания поля name
     * @return
     */
    public String readNameRoute()  {
        System.out.println("Введите name:");
        while (true) {
            String nameRoute = interfaceRead.read();
            try{
                if (nameRoute.isEmpty()) {
                    throw new ReaderException("Поле name не может быть пустым!Пожалуйста, введите name еще раз:");
                }
            }catch(ReaderException e){
                System.out.println(e.getMessage());
                continue;
            }
            try {
                char[] l = nameRoute.toCharArray();
                for (int i = 0; i < l.length; i++) {
                    if (Character.isDigit(l[i])) {
                        i = l.length;
                        throw new ConsoleException("Поле name введено неправильно, name должно состоять из букв! Пожалуйста, введите name еще раз:");
                    }
                }
            } catch(ConsoleException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return nameRoute;
        }
    }

    /**
     * Метод для корректнго считывания поля distance
     * @return
     */
    public Long readDistance() {
        System.out.println("Введите distance:");
        while (true) {
            String line = interfaceRead.read();
            if (line.isEmpty()) {
                System.out.println("Поле distance не может быть пустым! Пожалуйста, введите distance еще раз:");
                continue;
            }
            long distance;
            try {
                distance = Long.parseLong(line);
            } catch (NumberFormatException exception) {
                System.out.println("Поле distance введено неправильно, оно должно быть целым числом!Пожалуйста, введите distance еще раз:");
                continue;
            }
            return distance;

        }
    }

    /**
     * Метод для корректнго считывания поля xCoordinates
     * @return
     */
    public Double readXCoordinates() {
        System.out.println("Введите координату Х Coordinates:");
        while (true) {
            String line = interfaceRead.read();
            if (line.isEmpty()) {
                System.out.println("Поле X не может быть пустым! Пожалуйста,введите координату Х еще раз: ");
                continue;
            }
            double x;
            try {
                x = Double.parseDouble(line);
            } catch (NumberFormatException exception) {
                System.out.println("Поле X введено неправильно, оно должно быть дробным или целым числом!Пожалуйста, введите координату X еще раз:");
                continue;
            }
            return x;
        }

    }

    /**
     * Метод для корректнго считывания поля yCoordinates
     * @return
     */
    public float readYCoordinates() {
        System.out.println("Введите координату Y Coordinates:");
        while (true) {
            String line = interfaceRead.read();
            float y;
            try {
                y = Float.parseFloat(line);
            } catch (NumberFormatException exception) {
                System.out.println("Поле Y введено неправльно, оно должно быть дробным или целым числом! Пожалуйста введите координату Y еще раз:");
                continue;
            }
            return y;
        }
    }

    /**
     * Метод для корректнго считывания поля nameLocationFrom
     * @return
     */
    public String readNameLocationFrom() {
        System.out.println("Введите name LocationFrom:");
        while (true) {
            String nameLocation = interfaceRead.read();
            if (nameLocation.isEmpty()) {
                return null;
            }
            try {
                char[] l = nameLocation.toCharArray();
                for (int i = 0; i < l.length; i++) {
                    if (Character.isDigit(l[i])) {
                        i = l.length;
                        throw new ConsoleException("Поле name введено неправильно, name должно состоять из букв! Пожалуйста, введите name LocationFrom еще раз:");
                    }
                }
            } catch (ConsoleException e) {
                System.out.println(e.getMessage());
                continue;
            }
            if (nameLocation.length() > 737) {
                System.out.println("Длина поля name не должно быть больше 737! Пожалуйста, введите name LocationFrom еще раз:");
                continue;
            }
            return nameLocation;
        }

    }

    /**
     * Метод для корректнго считывания поля xLocationFrom
     * @return
     */
    public Float readXLocationFrom() {
        System.out.println("Введите координату Х LocationFrom:");
        while (true) {
            String line = interfaceRead.read();
            if (line.isEmpty()) {
                System.out.println("Поле X не может быть пустым! Пожалуйста, введите координату X LocationFrom еще раз:");
                continue;
            }
            float x;
            try {
                x = Float.parseFloat(line);
            } catch (NumberFormatException exception) {
                System.out.println("Поле X введено неправльно, оно должно быть дробным или целым числом! Пожалуйста введите координату X еще раз:");
                continue;
            }
            return x;

        }
    }

    /**
     * Метод для корректнго считывания поля yLocationFrom
     * @return
     */
    public Long readYLocationFrom() {
        System.out.println("Введите координату Y LocationFrom:");
        while (true) {
            String line = interfaceRead.read();
            if (line.isEmpty()) {
                System.out.println("Поле Y не может быть пустым! Пожалуйста, введите координату Y LocationFrom еще раз:");
                continue;
            }
            long y;
            try {
                y = Long.parseLong(line);
            } catch (NumberFormatException exception) {
                System.out.println("Поле Y введено неправильно, оно должно быть целым числом! Пожалуйста, введите координату Y LocationFrom еще раз:");
                continue;
            }
            return y;
        }
    }

    /**
     * Метод для корректнго считывания поля zLocationFrom
     * @return
     */
    public long readZLocationFrom() {
        System.out.println("Введите координату Z LocationFrom:");
        while (true) {
            String line = interfaceRead.read();
            long z;
            try {
                z = Long.parseLong(line);
            } catch (NumberFormatException exception) {
                System.out.println("Поле Z введено неправильно, оно должно быть целым числом! Пожалуйста, введите координату Z LocationFrom еще раз:");
                continue;

            }
            return z;
        }
    }

    /**
     * Метод для корректнго считывания поля xLocationTo
     * @return
     */
    public Integer readXLocationTo() {
        System.out.println("Введите координату Х LocationTo:");
        while (true) {
            String line = interfaceRead.read();
            if (line.isEmpty()) {
                System.out.println("Поле X не может быть пустым! Пожалуйста, введите координату X LocationTo еще раз:");
                continue;
            }
            int x;
            try {
                x = Integer.parseInt(line);
            } catch (NumberFormatException exception) {
                System.out.println("Поле X введено неправильно, оно должно быть целым числом! Пожалуйста, введите координату X LocationTo еще раз:");
                continue;
            }
            return x;
        }
    }

    /**
     * Метод для корректнго считывания поля yLocationTo
     * @return
     */
    public int readYLocationTo() {
        System.out.println("Введите координату Y LocationTo:");
        while (true) {
            String line = interfaceRead.read();
            int y;
            try {
                y = Integer.parseInt(line);
            } catch (NumberFormatException exception) {
                System.out.println("Поле Y введено неправильно, оно должно быть целым числом! Пожалуйста, введите координату Y LocationTo еще раз:");
                continue;
            }
            return y;
        }
    }

    /**
     * Метод для корректнго считывания поля zLocationTo
     * @return
     */
    public Long readZLocationTo() {
        System.out.println("Введите координату Z LocationTo:");
        while (true) {
            String line = interfaceRead.read();
            if (line.isEmpty()) {
                System.out.println("Поле Z не может быть пустым! Пожалуйста, введите координу Z LocationTo еще раз:");
                continue;
            }
            long z;
            try {
                z = Long.parseLong(line);
            } catch (NumberFormatException exception) {
                System.out.println("Поле Z введено неправильно, оно должно быть целым числом! Пожалуйста введите координату Z LocationTo еще раз:");
                continue;
            }
            return z;
        }
    }

    /**
     * Метод для корректнго считывания поля id
     * @param line-команда и id, введенные с консоли
     * @param trueLine-правильное название команды
     * @return
     */
    public Long readIdElement(String line,String trueLine) {
        long id;
        while(true) {
            if (line.length() < (trueLine.length()+1)) {
                System.out.println("Вы не ввели id! Пожалуйста введите данную команду и id еще раз:");
                line = interfaceRead.read();
                continue;
            }

            while (true) {
                String idElement = line.substring(trueLine.length()).trim();
                try {
                    id = Long.parseLong(idElement);
                    if (id<=0){
                        System.out.println("Поле id должно быть больше 0!Пожалуйста, введите id еще раз:");
                        line= interfaceRead.read();
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Поле id введено неправильно, оно должно быть целым числом!Пожалуйста введите данную команду и id еще раз:");
                    line = interfaceRead.read();
                    continue;
                }
                return id;
            }
        }

    }

    /**
     * Метод для корректнго считывания подстроки name для команды filter_contains_name
     * @param line-подстрока и команды, введенные с консоли
     * @return
     */
    public String readFilterContainsName(String line){
        String name;
        while(true){
            if (line.length()< 21){
                System.out.println("Вы не ввели name!Пожалуйста, введите команду filter_contains_name и name еще раз:");
                line=interfaceRead.read();
            }
            while(true){
                name=line.substring(20).trim();
                try {
                    char[] l = name.toCharArray();
                    for (int i = 0; i < l.length; i++) {
                        if (Character.isDigit(l[i])) {
                            i = l.length;
                            throw new ConsoleException("Поле name введено неправильно, name должно состоять из букв!Пожалуйста, введите name еще раз:");
                        }
                    }
                } catch (ConsoleException e) {
                    System.out.println(e.getMessage());
                    line=interfaceRead.read();
                    continue;
                }
                return name;
            }
        }
    }

    /**
     * Метод для корректнго считывания поля distance для команды filter_less_than_distance
     * @param line- значение поле distance и команда, введенные с консоли
     * @return
     */
    public Long readFilterLessThanDistance(String line){
        Long distance;
        while(true){
            if (line.length()<26){
                System.out.println("Вы не ввели поле distance! Введите команду filter_less_than_distance и distance еще раз:");
                line=interfaceRead.read();
            }
            while(true){
                String l=line.substring(25).trim();
                try{
                    distance=Long.parseLong(l);
                    if (distance<=1){
                        System.out.println("Поле distance должно быть больше 1!Пожалуйста, введите distance еще раз:");
                        line= interfaceRead.read();
                        continue;
                    }
                }
                catch (NumberFormatException e){
                    System.out.println("Поле distance введено неправильно! Пожалуйста, введите команду filter_less_than_distance и distance еще раз:");
                    line= interfaceRead.read();
                    continue;
                }
                return distance;
            }
        }
    }

    /**
     * Метод для корректнго считывания поля fileName
     * @param line-команда и fileName, введенные с консоли
     * @return
     */
    public String readFileName(String line){
        String fileName;
        while(true) {
            if (line.length() < 15) {
                System.out.println("Вы не ввели fileName! Пожалуйста, введите команду execute_script и fileName еще раз:");
                line = interfaceRead.read();
                continue;
            }
            fileName = line.substring(14).trim();
            return fileName;
        }
    }

    /**
     * Метод запускает программы, считывает название команд и управляет выполнением команд
     * @param interfaceRead-объект класса InterfaceReader
     * @param executor-объект класса Executor
     */

    public void go(InterfaceRead interfaceRead, Executor executor) {
        System.out.println("Список существующих команд:");
        System.out.println(executor.executeHelp());
        System.out.println("Введите команду:");
        while (true) {
            String line = interfaceRead.read();
            if (line.equals("help")) {
                System.out.println(executor.executeHelp());
            } else if (line.equals("info")) {
                System.out.println(executor.executeInfo());
            } else if (line.equals("show")) {
                System.out.println(executor.executeShow());
            } else if (line.equals("add")) {
                System.out.println(executor.executeAddElement(readNameRoute(), readXCoordinates(), readYCoordinates(), readXLocationFrom(), readYLocationFrom(), readZLocationFrom(), readNameLocationFrom(), readXLocationTo(), readYLocationTo(), readZLocationTo(), readDistance()));
            } else if (line.contains("update")) {
                System.out.println(executor.executeUpdateIdElement(readIdElement(line,"update"),readNameRoute(), readXCoordinates(), readYCoordinates(), readXLocationFrom(), readYLocationFrom(), readZLocationFrom(), readNameLocationFrom(), readXLocationTo(), readYLocationTo(), readZLocationTo(), readDistance()));
            } else if(line.equals("clear")){
                System.out.println(executor.executeClear());
            }else if(line.equals("save")){
                System.out.println(executor.executeSave());
            }else if(line.equals("sort")){
                System.out.println(executor.executeSort());
            }else if (line.equals("exit")){
                System.out.println("Программа завершена");
                break;
            }else if(line.equals("remove_first")){
                System.out.println(executor.executeRemoveFirst());
            }else if(line.equals("min_by_id")){
                System.out.println(executor.executeMinById());
            }else if(line.contains("remove_by_id")){
                System.out.println(executor.executeRemoveById(readIdElement(line, "remove_by_id")));
            }else if(line.equals("add_if_min")){
                System.out.println(executor.executeAddIfMin(readNameRoute(), readXCoordinates(), readYCoordinates(), readXLocationFrom(), readYLocationFrom(), readZLocationFrom(), readNameLocationFrom(), readXLocationTo(), readYLocationTo(), readZLocationTo(), readDistance()));
            }else if(line.contains("filter_contains_name")){
                System.out.println(executor.executeFilterContainsName(readFilterContainsName(line)));
            }else if(line.contains("filter_less_than_distance")){
                System.out.println(executor.executeFilterLessThanDistance(readFilterLessThanDistance(line)));
            }else if(line.contains("execute_script")){
                System.out.println(executor.executeScript(readFileName(line)));
            } else{
                System.out.println("Такой команды не существует");
                }
            }
        }
    }


