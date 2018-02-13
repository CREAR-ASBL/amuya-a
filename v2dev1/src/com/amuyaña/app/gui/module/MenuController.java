/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyaña.app.gui.module;

import com.amuyaña.app.gui.AppController;
import static com.amuyaña.app.gui.module.Module.DUALITIES;
import static com.amuyaña.app.gui.module.Module.LOGGER;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Ayar Portugal <ayar.portugal@amuyaña.com>
 */
public class MenuController implements Initializable {
    @FXML
    AppController appController;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setAppController(AppController aThis) {
        this.appController = aThis;
    }
    
    @FXML
    private void debugAction(){
        appController.log(false, "I am Ayar and I have activated this button.");
    }
    
    @FXML
    private void loadLogger(){
        this.appController.showModule(LOGGER);
    }
    
    @FXML
    private void loadDualities(){
        this.appController.showModule(DUALITIES);
    }
}
