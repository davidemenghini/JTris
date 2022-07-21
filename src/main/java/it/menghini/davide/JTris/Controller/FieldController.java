package it.menghini.davide.JTris.Controller;



import java.util.Optional;

public interface FieldController<L,S,V> {

    void changeGameStatus(S status);

    Optional<V> applyRule();

    S getGameStatus();

    void setValueAt(L location, V value);

    void changeTurn();

    char getTurn();
}
