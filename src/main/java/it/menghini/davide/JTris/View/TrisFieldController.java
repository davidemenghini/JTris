package it.menghini.davide.JTris.View;

import it.menghini.davide.JTris.Controller.DefaultFieldController;
import it.menghini.davide.JTris.Controller.FieldController;
import it.menghini.davide.JTris.Model.*;

import javafx.fxml.Initializable;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.List;

import java.util.Objects;
import java.util.ResourceBundle;

public class TrisFieldController implements FieldUpdateListener<Locations, TrisValues,GameStatus>, Initializable {




    public Label roundlabel;
    public Rectangle cell0_0;
    public Rectangle cell0_1;
    public Rectangle cell0_2;
    public Rectangle cell1_0;
    public Rectangle cell1_1;
    public Rectangle cell1_2;
    public Rectangle cell2_0;
    public Rectangle cell2_1;
    public Rectangle cell2_2;

    private final FieldController<Locations, GameStatus,TrisValues> fieldController = new DefaultFieldController(List.of(this));

    @Override
    public void firePGWin(GameStatus status) {
        //TODO
        if(this.fieldController.getGameStatus().equals(GameStatus.END)){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION,"complimenti giocatore "+this.fieldController.getTurn()+", hai vinto!!", ButtonType.OK);
            a.showAndWait();
        }
    }

    @Override
    public void fireSetValue(TrisValues value, Locations location) {
        if(value.equals(TrisValues.CERCHIO)){
            Objects.requireNonNull(getCellByLocation(location)).setFill(Color.color(1, 0, 0));
        }else{
            Objects.requireNonNull(getCellByLocation(location)).setFill(Color.color(0,0,1));
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.fieldController.changeGameStatus(GameStatus.PLAYING);
        this.roundlabel.setText("giocatore 1");
    }






    private Rectangle getCellByLocation(Locations location){
        if(location.getX()==0 && location.getY()==0) return this.cell0_0;
        else if(location.getX()==0 && location.getY()==1) return this.cell0_1;
        else if(location.getX()==0 && location.getY()==2) return this.cell0_2;
        else if(location.getX()==1 && location.getY()==0) return this.cell1_0;
        else if(location.getX()==1 && location.getY()==1) return this.cell1_1;
        else if(location.getX()==1 && location.getY()==2) return this.cell1_2;
        else if(location.getX()==2 && location.getY()==0) return this.cell2_0;
        else if(location.getX()==2 && location.getY()==1) return this.cell2_1;
        else if(location.getX()==2 && location.getY()==2) return this.cell2_2;
        else return null;
    }


    public void cell0_0Click(MouseEvent mouseEvent) {
        setValueEvent(new Locations(0,0));
    }

    public void cell0_1Click(MouseEvent mouseEvent) {
        setValueEvent(new Locations(0,1));
    }

    public void cell0_2Click(MouseEvent mouseEvent) {
        setValueEvent(new Locations(0,2));
    }

    public void cell1_0Click(MouseEvent mouseEvent) {
        setValueEvent(new Locations(1,0));
    }

    public void cell1_1Click(MouseEvent mouseEvent) {
        setValueEvent(new Locations(1,1));
    }

    public void cell1_2Click(MouseEvent mouseEvent) {
        setValueEvent(new Locations(1,2));
    }

    public void cell2_0Click(MouseEvent mouseEvent) {
        setValueEvent(new Locations(2,0));
    }

    public void cell2_1Click(MouseEvent mouseEvent) {
        setValueEvent(new Locations(2,1));
    }

    public void cell2_2Click(MouseEvent mouseEvent) {
        setValueEvent(new Locations(2,2));
    }


    private void setValueEvent(Locations location){
        System.out.println("x:"+location.getX()+", Y:"+ location.getY());
        if(this.fieldController.getTurn()=='1'){
            this.fieldController.setValueAt(location,TrisValues.CERCHIO);
        }else{
            this.fieldController.setValueAt(location,TrisValues.CROCE);
        }
        if(this.fieldController.applyRule().isPresent()){
            System.out.println("apply rule presente...");
            this.fieldController.changeGameStatus(GameStatus.END);
        }else System.out.println("apply rule non presente....");
        this.fieldController.changeTurn();
        if(this.fieldController.getTurn()=='1'){
            System.out.println("impostando il giocatore 1 come prossimo turno...");
            this.roundlabel.setText("giocatore 1");
        }
        else if(this.fieldController.getTurn()=='2'){
            System.out.println("impostando il giocatore 2 come prossimo turno...");
            this.roundlabel.setText("giocatore 2");
        }

    }
}
