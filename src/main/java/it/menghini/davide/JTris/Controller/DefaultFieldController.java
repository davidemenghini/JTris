package it.menghini.davide.JTris.Controller;

import it.menghini.davide.JTris.Model.*;

import java.util.List;
import java.util.Optional;


public class DefaultFieldController implements FieldController<Locations, GameStatus, TrisValues>{

    private final TrisField<Locations, TrisValues,GameStatus> field;
    private final TrisRule<TrisValues> rule = TrisRule::standardTrisRule;
    private char round;

    public DefaultFieldController(List<FieldUpdateListener<Locations,TrisValues,GameStatus>> listeners){
        this.field = new DefaultTrisField<>(3,3,GameStatus.STARTING, listeners);
        this.field.initialiazeField();
        this.round = '1';
    }

    @Override
    public void changeGameStatus(GameStatus status) {
        this.field.setGameStatus(status);

    }

    @Override
    public Optional<TrisValues> applyRule() {
        boolean check;
        List<List<Locations>> list = getLocations();
        for (List<Locations> l: list) {
            List<TrisCell<TrisValues>> x = this.field.getValues(l);
            check = rule.checkValues(x,TrisValues.VUOTO);
            if(check){
                return Optional.of(x.get(0).getValue());
            }
        }
        return Optional.empty();
    }

    @Override
    public GameStatus getGameStatus() {
        return this.field.getGameStatus();
    }


    @Override
    public void setValueAt(Locations location, TrisValues value) {
        if(this.field!=null){
            this.field.setTrisCell(location,value);
        }else{
            throw new NullPointerException("il campo e' Null!!");
        }

    }

    @Override
    public void changeTurn() {
        System.out.println("cambiando il turno del giocatore...");
        if(this.round=='1'){
            this.round = '2';
        }else{
            this.round = '1';
        }
    }

    @Override
    public char getTurn() {
        return this.round;
    }


    private List<List<Locations>> getLocations(){
        return List.of(StaticLocations.oneRow,
                StaticLocations.twoRow,
                StaticLocations.threeRow,
                StaticLocations.oneColumn,
                StaticLocations.twoColumn,
                StaticLocations.threeColumn,
                StaticLocations.leftDiagonal,
                StaticLocations.rightDiagonal);
    }
}
