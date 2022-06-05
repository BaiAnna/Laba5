package commands;

/**
 * Класс для передачи аргумента distance методу
 */
public class ArgumentDistance implements ArgumentInterface {
    Long distance;
    public ArgumentDistance(Long distance){
        this.distance=distance;
    }
}
