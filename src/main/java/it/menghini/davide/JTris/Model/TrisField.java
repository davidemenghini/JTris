package it.menghini.davide.JTris.Model;

import java.util.List;

public interface TrisField<L,V,S>{


    void setTrisCell(L location, V value);

    List<TrisCell<V>> getValues(List<L> location);

    S getGameStatus();

    void setGameStatus(S status);

    void initialiazeField();
}
