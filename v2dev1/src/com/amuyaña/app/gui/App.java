/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyaña.app.gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ayar Portugal <ayar.portugal@amuyaña.com>
 */
public class App extends Application {
    
    @FXML AppController appController;
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("App.fxml"));
        Parent root = loader.load();
        appController = loader.getController();
        appController.log(true, "Main FXML file loaded (App.fxml), and "
                + "AppController executed. Now starting the  stage...");
        
        Scene scene = new Scene(root);
        stage.setTitle("Amuyaña 2.0dev");
        stage.setScene(scene);
        appController.log(true, "Executing stage.show() and now waiting for "
                + "user actions.");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
