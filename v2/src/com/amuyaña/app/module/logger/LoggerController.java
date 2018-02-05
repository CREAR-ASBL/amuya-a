/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyaña.app.module.logger;

import com.amuyaña.app.AppController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Ayar Portugal <ayar.portugal@amuyaña.com>
 */
public class LoggerController  {
    AppController appController;
    /**
     * Initializes the controller class.
     */
    
    public void initialize() {
        
    }    
    
    public void injectAppController(AppController appController){
        
        this.appController = appController;
        System.out.println("after setting main controller");
    }
    
}
