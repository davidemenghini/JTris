package it.menghini.davide.JTris.Model;

import java.util.List;

public final class StaticLocations {

    public static List<Locations> oneRow = List.of(new Locations(0,0),
            new Locations(0,1),
            new Locations(0,2));
    public static List<Locations> twoRow = List.of(new Locations(1,0),
            new Locations(1,1),
            new Locations(1,2));
    public static List<Locations> threeRow = List.of(new Locations(1,0),
            new Locations(1,1),
            new Locations(1,2));
    public static List<Locations> oneColumn = List.of(new Locations(0,0),
            new Locations(1,0),
            new Locations(2,0));
    public static List<Locations> twoColumn = List.of(new Locations(0,1),
            new Locations(1,1),
            new Locations(2,1));
    public static List<Locations> threeColumn = List.of(new Locations(0,2),
            new Locations(1,2),
            new Locations(2,2));
    public static List<Locations> leftDiagonal = List.of(new Locations(0,0),
            new Locations(1,1),
            new Locations(2,2));
    public static List<Locations> rightDiagonal = List.of(new Locations(0,2),
            new Locations(1,1),
            new Locations(2,0));

}
