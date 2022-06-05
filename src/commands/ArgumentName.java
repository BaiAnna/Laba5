package commands;

/**
 * Класс для передачи аргумента name методу
 */
public class ArgumentName implements  ArgumentInterface{
    String name;
    public ArgumentName(String name){
        this.name=name;
    }
}
