package it.menghini.davide.JTris.Model;

import java.util.Objects;

public class Locations {

    private final int x;
    private final int y;

    public Locations(int x, int y){
        this.x = x;
        this.y = y;
    }


    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Locations)) return false;
        Locations locations = (Locations) o;
        return x == locations.x && y == locations.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
