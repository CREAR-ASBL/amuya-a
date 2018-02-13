/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyaña.app.gui.module.logger;

import com.amuyaña.app.gui.AppController;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


/**
 * FXML Controller class
 *
 * @author Ayar Portugal <ayar.portugal@amuyaña.com>
 */
public class LoggerController  {
    @FXML
    AppController appController;
    
    @FXML
    private VBox loggerOutput;
    
    /**
     * Initializes the controller class.
     */
    
    public void initialize() {

    }    
    
    public void setAppController(AppController aThis) {
        this.appController = aThis;
    }

    public void appendLog(String log){
        
        Label logEntry = new Label();
        logEntry.setAlignment(Pos.TOP_LEFT);
        logEntry.setMaxHeight(1.7976931348623157E308);
        logEntry.setMaxWidth(1.7976931348623157E308);
        logEntry.setMinHeight(0);
        logEntry.setMinWidth(0);
        logEntry.setWrapText(true);
        
        String timeStamp;
        
        Date now = new Date();
        timeStamp = now.toString();
                
        logEntry.setText("[" + timeStamp + "] " + log);
        
        this.loggerOutput.getChildren().add(logEntry);

    }
    
}
