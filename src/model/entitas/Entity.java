package model.entitas;

import model.items.Point;

public abstract class Entity {
    private String name;
    private String location;
    private Point coordinate;

    public Entity(String name, String location) {
        this.name = name;
        this.location = location;
        this.coordinate = new Point(0, 0);
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void showLocation() {
        System.out.println("Kamu berada di " + location);
    }

    public void ShowCoordinate() {
        System.out.println("Kamu berada di " + coordinate.getX() + "," + coordinate.getY());
    }

    public void moveTo(Point newCoordinate) {
        this.coordinate = newCoordinate;
    }
}