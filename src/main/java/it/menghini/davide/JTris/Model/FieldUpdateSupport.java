package it.menghini.davide.JTris.Model;

import java.util.ArrayList;
import java.util.List;

public final class FieldUpdateSupport<L,V,S> {

    List<FieldUpdateListener<L,V,S>> fieldUpdateListeners = new ArrayList<>();

    void addListener(FieldUpdateListener<L,V,S> listener){
        if(listener!=null){
            this.fieldUpdateListeners.add(listener);
        }
    }

    void removeListeners(FieldUpdateListener<L,V,S> listener){
        if(listener!=null){
            this.fieldUpdateListeners.remove(listener);
        }
    }

    void firePGWin(S value){
        this.fieldUpdateListeners.forEach(x->x.firePGWin(value));
    }

    void fireSetValue(V value, L location){
        this.fieldUpdateListeners.forEach(x->x.fireSetValue(value, location));
    }


}
