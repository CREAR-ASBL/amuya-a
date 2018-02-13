/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyaña.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ayar Portugal <ayar.portugal@amuyaña.com>
 */
public class App extends Application {
    static AppController appController;
    static public Scene scene;
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("App.fxml"));
        Parent root = loader.load();

        this.appController = (AppController)loader.getController();
        
        this.scene = new Scene(root);
        
        stage.setScene(this.scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
