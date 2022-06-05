package commands;

import commands.InterfaceCommand;

import java.util.Map;
/**
 * Класс Invoker
 */
public class Executor {

    private Map<String, InterfaceCommand> commands;

    /**
     * Метод заполняет коллекцию Map commands командыми переданными в параметрах
     * @param commands-комманды для заполнения коллекции Map commands
     */
    public void setCommands (Map<String, InterfaceCommand> commands){
        this.commands=commands;
    }

    /**
     * Метод возырвщиет команду, соответствующую данному ключю
     * @param key-ключ команды
     * @return
     */
    public InterfaceCommand getCommands(String key){
        InterfaceCommand com=commands.get(key);
        return com;

    }

    /**
     * Метод для выполнения команды help
     * @return
     */
    public String executeHelp(){
        ArgumentEmpty argumentEmpty=new ArgumentEmpty();
        return commands.get("help").execute(argumentEmpty);
    }

    /**
     * Метод для выполнения команды info
     * @return
     */
    public String executeInfo(){
        ArgumentEmpty argumentEmpty= new ArgumentEmpty();
        return commands.get("info").execute(argumentEmpty);
    }

    /**
     * Метод для выполнения команды show
     * @return
     */
    public String executeShow(){
        ArgumentEmpty argumentEmpty=new ArgumentEmpty();
        return commands.get("show").execute(argumentEmpty);
    }

    /**
     * Метод для выполнения команды add
     * @param name-имя элемента
     * @param coordinatesX
     * @param coordinatesY
     * @param fromX
     * @param fromY
     * @param fromZ
     * @param fromName
     * @param toX
     * @param toY
     * @param toZ
     * @param distance
     * @return
     */
    public String executeAddElement(String name, Double coordinatesX, float coordinatesY, Float fromX,Long fromY, float fromZ, String fromName,Integer toX, int toY, Long toZ, Long distance){
        ArgumentElement argumentElement=new ArgumentElement(name, coordinatesX, coordinatesY, fromX, fromY, fromZ, fromName, toX, toY, toZ, distance);
        return commands.get("add").execute(argumentElement);
    }

    /**
     * Метод для выполнения команды update
     * @param id
     * @param name
     * @param coordinatesX
     * @param coordinatesY
     * @param fromX
     * @param fromY
     * @param fromZ
     * @param fromName
     * @param toX
     * @param toY
     * @param toZ
     * @param distance
     * @return
     */
    public String executeUpdateIdElement(Long id, String name, Double coordinatesX, float coordinatesY, Float fromX,Long fromY, float fromZ, String fromName,Integer toX, int toY, Long toZ, Long distance){
        ArgumentUpdate argumentUpdate=new ArgumentUpdate(id, name, coordinatesX, coordinatesY, fromX, fromY, fromZ, fromName, toX, toY, toZ, distance);
        return commands.get("update").execute(argumentUpdate);
    }
    /**
     * Метод для выполнения команды clear
     */
    public String executeClear(){
        ArgumentEmpty argumentEmpty=new ArgumentEmpty();
        return commands.get("clear").execute(argumentEmpty);
    }

    /**
     * Метод для выполнения команды save
     * @return
     */
    public String executeSave(){
        ArgumentEmpty argumentEmpty=new ArgumentEmpty();
        return commands.get("save").execute(argumentEmpty);
    }

    /**
     * Метод для выполнения команды sort
     * @return
     */
    public String executeSort(){
        ArgumentEmpty argumentEmpty=new ArgumentEmpty();
        return commands.get("sort").execute(argumentEmpty);
    }

    /**
     * Метод для выполнения команды remove_first
     * @return
     */
    public String executeRemoveFirst(){
        ArgumentEmpty argumentEmpty=new ArgumentEmpty();
        return commands.get("remove_first").execute(argumentEmpty);
    }

    /**
     * Метод для выполнения команды min_by_id
     * @return
     */
    public String executeMinById(){
        ArgumentEmpty argumentEmpty=new ArgumentEmpty();
        return commands.get("min_by_id").execute(argumentEmpty);
    }

    /**
     * Метод для выполнения команды remove_by_id
     * @param id-поле id элемента
     * @return
     */
    public String executeRemoveById(Long id){
        ArgumentId argumentId=new ArgumentId(id);
        return commands.get("remove_by_id").execute(argumentId);
    }

    /**
     * Метод для выполнения команды aad_if_min
     * @param name
     * @param coordinatesX
     * @param coordinatesY
     * @param fromX
     * @param fromY
     * @param fromZ
     * @param fromName
     * @param toX
     * @param toY
     * @param toZ
     * @param distance
     * @return
     */
    public String executeAddIfMin(String name, Double coordinatesX, float coordinatesY, Float fromX,Long fromY, float fromZ, String fromName,Integer toX, int toY, Long toZ, Long distance){
        ArgumentElement argumentElement=new ArgumentElement(name, coordinatesX, coordinatesY, fromX, fromY, fromZ, fromName, toX, toY, toZ, distance);
        return commands.get("add_if_min").execute(argumentElement);
    }

    /**
     * Метод для выполнения команды filter_contains_name
     * @param name-заданная подстрока имени
     * @return
     */
    public String executeFilterContainsName(String name){
        ArgumentName argumentName=new ArgumentName(name);
        return commands.get("filter_contains_name").execute(argumentName);
    }

    /**
     * Метод для выполнения команды filter_less_than_distance
     * @param distance-поле distance
     * @return
     */
    public String executeFilterLessThanDistance(Long distance){
        ArgumentDistance argumentDistance=new ArgumentDistance(distance);
        return commands.get("filter_less_than_distance").execute(argumentDistance);
    }

    /**
     * Метод для выполнения команды execute_script
     * @param fileName-имя файла, содержащий скрипт
     * @return
     */
    public String executeScript(String fileName){
        ArgumentScript argumentScript=new ArgumentScript(fileName);
        return commands.get("execute_script").execute(argumentScript);
    }
}
