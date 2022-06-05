package commands;

/**
 * Класс для передачи аргумента Id методу
 */
public class ArgumentId implements ArgumentInterface{
    long id;
    public ArgumentId(Long id){
        this.id=id;
    }
}
