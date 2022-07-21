package it.menghini.davide.JTris.Model;

public interface TrisCell<V> {

    V getValue();

    void setValue(V value) throws NullPointerException;



}
