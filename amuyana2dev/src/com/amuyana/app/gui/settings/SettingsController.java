/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.gui.settings;

import com.amuyana.app.gui.AppController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author ayar
 */
public class SettingsController implements Initializable {

    private AppController appController;

    @FXML private Button btnConnect;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setAppController(AppController aThis) {
        this.appController=aThis;
    }
    
    @FXML
    private void connectToDb(){
        appController.connectToDb();
    }

    public void clickConnect() {
        btnConnect.fire();
    }
}
