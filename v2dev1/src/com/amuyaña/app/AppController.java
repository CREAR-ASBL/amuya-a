/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyaña.app;

import com.amuyaña.app.module.BlankController;
import com.amuyaña.app.module.Module;
import static com.amuyaña.app.module.Module.DEFAULT_MODULE;
import static com.amuyaña.app.module.Module.LOGGER;
import com.amuyaña.app.module.logger.LoggerController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;


/**
 *
 * @author Ayar Portugal <ayar.portugal@amuyaña.com>
 */
public class AppController {
    @FXML
    LoggerController loggerController;
    
    @FXML
    private SplitPane mainContainer;
    private BlankController blankController;

    public void initialize() throws IOException {
        
        
        loadModules();
        
        showModule(LOGGER);
    }

    private void setupMainContainer() {
        
        
    }
    
    static double count=0;
    
    @FXML
    public void testStuff(){
        if(count==1){
            count=0;
        } else {
            mainContainer.setDividerPositions(count,1-count);
            count += 0.2;
        }
    }
    
    private void loadModules() throws IOException {
        for(Module m:Module.values()){
            FXMLLoader leftLoader = new FXMLLoader(getClass().getResource(m.getUrlLeft()));
            FXMLLoader centerLoader = new FXMLLoader(getClass().getResource(m.getUrlCenter()));
            FXMLLoader rightLoader = new FXMLLoader(getClass().getResource(m.getUrlRight()));
            
            ScrollPane leftPanel = leftLoader.load();
            ScrollPane centerPanel = centerLoader.load();
            ScrollPane rightPanel = rightLoader.load();
            
            m.setPanes(leftPanel, centerPanel, rightPanel);
            switch(m){
                case DEFAULT_MODULE:{
                    this.blankController = leftLoader.getController();
                    break;
                }
                case LOGGER:{
                    this.loggerController = leftLoader.getController();
                    break;
                }
            }
            
        }
    }

    private void showModule(Module module) {
        mainContainer.getItems().clear();
        mainContainer.getItems().add(module.getLeftPane());
        mainContainer.getItems().add(module.getCenterPane());
        mainContainer.getItems().add(module.getRightPane());
    }
}
