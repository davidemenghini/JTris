package it.menghini.davide.JTris.Model;

import java.util.Objects;

public class DefaultTrisCell<V> implements TrisCell<V>{

    private V value;

    public DefaultTrisCell(V value){
        this.value = value;
    }



    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public void setValue(V value) {
        if(value!=null){
            this.value = value;
        }else throw new NullPointerException("");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DefaultTrisCell)) return false;
        DefaultTrisCell<?> that = (DefaultTrisCell<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
