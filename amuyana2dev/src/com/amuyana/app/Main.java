package com.amuyana.app;

import com.amuyana.app.controllers.AppController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Amuyaña Main class.
 * 
 * @author Ayar Portugal <ayarportugal@gmail.com>
 */
public class Main extends Application {
    
    @FXML AppController appController;
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/App.fxml"));
        Parent root = loader.load();
        appController = loader.getController();
        
        Scene scene = new Scene(root,1000,800,true);
        
        scene.getStylesheets().add(getClass().getResource("/com/amuyana/app/resources/mainApp/style.css").toExternalForm());
        
        stage.setTitle("Amuyaña 3 dev");
        stage.setScene(scene);
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
