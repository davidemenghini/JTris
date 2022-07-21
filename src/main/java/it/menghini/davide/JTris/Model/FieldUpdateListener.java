package it.menghini.davide.JTris.Model;

public interface FieldUpdateListener<L,V,S> {



    void firePGWin(S status);

    void fireSetValue(V value, L location);
}
