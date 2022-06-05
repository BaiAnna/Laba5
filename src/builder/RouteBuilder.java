package builder;

import collectionClass.Coordinates;
import collectionClass.LocationFrom;
import collectionClass.LocationTo;
import collectionClass.Route;
import java.lang.*;


/**
 * Класс для создания объектов
 */
public class RouteBuilder implements InterfaceBuilder {
    private static long idCount;
    public RouteBuilder(){}
    public RouteBuilder(long idCount){
        this.idCount=idCount;
    }
    private String localDate;
    private Long id;
    private String name;
    private Coordinates coordinates;
    private LocationFrom from;
    private LocationTo to;
    private Long distance;


    /**
     * Метод для генерации Id элемента коллекции
     * @return
     */
    @Override
    public InterfaceBuilder generationId() {
        id=idCount;
        idCount++;
        return this;
    }

    /**
     * Метод для создания даты
     * @param localDate
     * @return
     */
    @Override
    public InterfaceBuilder fixCreationDate(String localDate){
        this.localDate=localDate;
        return this;
    }

    /**
     * Метод для создания id
     * @param id
     * @return
     */
    @Override
    public InterfaceBuilder fixId(Long id){
        this.id=id;
        return this;
    }

    /**
     * Метод для создания name
     * @param name
     * @return
     */
    @Override
    public InterfaceBuilder fixName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Метод для создания coordinates
     * @param coordinates
     * @return
     */
    @Override
    public InterfaceBuilder fixCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    /**
     * Метод для создания locationFrom
     * @param from
     * @return
     */
    @Override
    public InterfaceBuilder fixLocationFrom(LocationFrom from) {
        this.from = from;
        return this;
    }

    /**
     * Метод для создания locationTo
     * @param to
     * @return
     */
    @Override
    public InterfaceBuilder fixLocationTo(LocationTo to) {
        this.to = to;
        return this;
    }

    /**
     * Метод для создания distance
     * @param distance
     * @return
     */
    @Override
    public InterfaceBuilder fixDistance(Long distance) {
        this.distance = distance;
        return this;
    }

    /**
     * Метод для создания конечного объекта
     * @return
     */
    @Override
    public Route build() {
        Route route = new Route(id, name, coordinates, from, to, distance);
        id=null;
        name=null;
        coordinates=null;
        from=null;
        to=null;
        distance=null;

        return route;
    }
}
