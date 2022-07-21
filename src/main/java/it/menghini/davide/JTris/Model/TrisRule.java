package it.menghini.davide.JTris.Model;

import java.util.List;

@FunctionalInterface
public interface TrisRule<V> {


    boolean checkValues(List<TrisCell<V>> values, V blankValue);


    static<V> boolean standardTrisRule(List<TrisCell<V>> values, V blankValue){
        return values.get(0).equals(values.get(1)) && values.get(1).equals(values.get(2)) && !values.get(0).getValue().equals(blankValue);
    }
}
