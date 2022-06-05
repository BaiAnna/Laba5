package commands;

/**
 * Класс для передачи аргументов элемента методу для добавления элемента в коллекцию
 */

public class ArgumentElement implements ArgumentInterface{
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
    public ArgumentElement(String name, Double coordinatesX, float coordinatesY, Float fromX,Long fromY, float fromZ, String fromName,Integer toX, int toY, Long toZ, Long distance){
        this.name=name;
        this.coordinatesX=coordinatesX;
        this.coordinatesY=coordinatesY;
        this.fromX=fromX;
        this.fromY=fromY;
        this.fromZ=fromZ;
        this.fromName=fromName;
        this.toX=toX;
        this.toY=toY;
        this.toZ=toZ;
        this.distance=distance;

    }
}
