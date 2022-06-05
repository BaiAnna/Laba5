package commands;

/**
 * Класс для передачи аргумента fileName методу
 */

public class ArgumentScript implements ArgumentInterface{
    String fileName;
    public ArgumentScript(String fileName){
        this.fileName=fileName;
    }
}
