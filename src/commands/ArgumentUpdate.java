package commands;

/**
 * Класс для передачи аргументов элемента для обновления значения элемента
 */

public class ArgumentUpdate implements ArgumentInterface{
    Long id;
    String name;
    Double coordinatesX;
    float coordinatesY;
    Float fromX;
    Long fromY;
    float fromZ;
    String fromName;
    Integer toX;
    int toY;
    Long toZ;
    Long distance;
    public ArgumentUpdate(Long id, String name, Double coordinatesX, float coordinatesY, Float fromX,Long fromY, float fromZ, String fromName,Integer toX, int toY, Long toZ, Long distance) {
        this.id = id;
        this.name = name;
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.fromX = fromX;
        this.fromY = fromY;
        this.fromZ = fromZ;
        this.fromName = fromName;
        this.toX = toX;
        this.toY = toY;
        this.toZ = toZ;
        this.distance = distance;
    }
}
