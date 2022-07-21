package it.menghini.davide.JTris.Model;

import java.util.ArrayList;
import java.util.List;

public class DefaultTrisField<S> implements TrisField<Locations, TrisValues,S> {


    private final TrisCell<TrisValues>[][] field;
    private final int height, width;
    private S status;
    private final FieldUpdateSupport<Locations,TrisValues,S> listeners = new FieldUpdateSupport<>();

    public DefaultTrisField(int h, int w, S status, List<FieldUpdateListener<Locations,TrisValues,S>> listeners){
        this.field = new DefaultTrisCell[h][w];
        listeners.forEach(this.listeners::addListener);
        this.height = h;
        this.width = w;
        this.status = status;
    }

    private void initializeEmptyField() {
        System.out.println("inizializzando l'array...");
        for(int i=0;i<height;i++) {
            for (int j = 0; j < width; j++) {
                this.field[i][j] = new DefaultTrisCell<>(TrisValues.VUOTO);
            }
        }
    }



    @Override
    public void setTrisCell(Locations location, TrisValues value) {
        if(this.field!=null){
            this.field[location.getX()][location.getY()] = new DefaultTrisCell<>(value);
            this.listeners.fireSetValue(value,location);
        }else {
            throw new NullPointerException("il campo dentro TrisField e' null!!");
        }

    }


    @Override
    public List<TrisCell<TrisValues>> getValues(List<Locations> location) {
        List<TrisCell<TrisValues>> rit = new ArrayList<>();
        for(int i=0;i<this.height;i++){
            for(int j=0;j<this.width;j++){
                if(location.contains(new Locations(i,j))){
                    rit.add(this.field[i][j]);
                }
            }
        }
        return rit;
    }

    @Override
    public S getGameStatus() {
        return this.status;
    }

    @Override
    public void setGameStatus(S status) {

        if(status!=null){
            this.status = status;
        }
        this.listeners.firePGWin(status);

    }

    @Override
    public void initialiazeField() {
        initializeEmptyField();
    }
}
