package it.menghini.davide.JTris;

import it.menghini.davide.JTris.View.TrisFieldController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafx/TrisFieldFXML.fxml"));
        Parent root = loader.load();
        TrisFieldController controller = loader.getController();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Tris...");
        primaryStage.setWidth(900);
        primaryStage.setHeight(600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
