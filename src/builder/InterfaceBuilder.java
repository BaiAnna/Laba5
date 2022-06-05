package builder;

import collectionClass.Coordinates;
import collectionClass.LocationFrom;
import collectionClass.LocationTo;
import collectionClass.Route;

// todo collections
// todo type erasure
// java io & nio

public interface InterfaceBuilder {
    public InterfaceBuilder generationId();
    public InterfaceBuilder fixCreationDate(String creationDate);
    public InterfaceBuilder fixId(Long id);
    public InterfaceBuilder fixName(String name);
    public InterfaceBuilder fixCoordinates(Coordinates coordinates);
    public InterfaceBuilder fixLocationFrom(LocationFrom from);
    public InterfaceBuilder fixLocationTo(LocationTo to);
    public InterfaceBuilder fixDistance(Long distance);
    public Route build();
}
