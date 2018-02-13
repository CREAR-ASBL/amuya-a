/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyaña.app.gui;

import com.amuyaña.app.gui.module.MenuController;
import com.amuyaña.app.gui.module.Module;
import static com.amuyaña.app.gui.module.Module.MENU;
import static com.amuyaña.app.gui.module.Module.DUALITIES;
import static com.amuyaña.app.gui.module.Module.LOGGER;
import com.amuyaña.app.gui.module.dualities.DualitiesController;
import com.amuyaña.app.gui.module.logger.LoggerController;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Ayar Portugal <ayar.portugal@amuyaña.com>
 */
public class AppController {
    
    @FXML
    private LoggerController loggerController;
    @FXML
    private MenuController menuController;
    @FXML
    private DualitiesController dualitiesController;
    
    @FXML
    private BorderPane mainContainer;
    
    

    public void initialize() throws IOException {
        loadModules();
        showApp(DUALITIES);
    }

    private void setupMainContainer() {
        
    }
    
    static double count=0;
    
    @FXML
    public void testStuff(){
        loggerController.appendLog(Double.toString(count));
        count++;
        
    }
    
    private void loadModules() throws IOException {
        for(Module m:Module.values()){
            FXMLLoader moduleLoader = new FXMLLoader(getClass().getResource(m.getModuleURL()));
            
            switch(m){
                case MENU:{
                    MenuBar menuContainer = moduleLoader.load();
                    m.setModuleContainer(menuContainer);
                    this.menuController = moduleLoader.getController();
                    this.menuController.setAppController(this);
                    break;
                }
                case LOGGER:{
                    AnchorPane moduleContainer = moduleLoader.load();
                    m.setModuleContainer(moduleContainer);
                    this.loggerController = moduleLoader.getController();
                    this.loggerController.setAppController(this);
                    break;
                }
                case DUALITIES:{
                    SplitPane moduleContainer = (SplitPane)moduleLoader.load();
                    m.setModuleContainer(moduleContainer);
                    this.dualitiesController = moduleLoader.getController();
                    this.dualitiesController.setAppController(this);
                    break;
                }
            }
        }
    }
    
    public void log(Boolean isSystemEvent, String event){
        this.loggerController.appendLog(event);
    }
    
    private void showApp(Module module) {
        this.mainContainer.setTop(Module.MENU.getModuleContainer());        
        this.mainContainer.setCenter(module.getModuleContainer());
    }
    
    public void showModule(Module module){
        this.mainContainer.setCenter(module.getModuleContainer());
    }
}
