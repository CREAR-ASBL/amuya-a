/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyaña.app.gui.module;

import com.amuyaña.app.gui.AppController;
import com.amuyaña.app.gui.module.logger.LoggerController;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;

/**
 *
 * @author Ayar Portugal <ayar.portugal@amuyaña.com>
 */
public enum Module {
    
    MENU("module/Menu.fxml"),
    LOGGER("module/logger/Logger.fxml"),
    DUALITIES("module/dualities/Dualities.fxml");
    
    private String moduleURL;
    
    private Object controller;
    
    private Node moduleContainer;

    
    private Module(String moduleURL) {
        this.moduleURL = moduleURL;
    }
    
    public void setModuleContainer(Node moduleContainer){
        this.moduleContainer = moduleContainer;
    }
    
    public Node getModuleContainer() {
        return this.moduleContainer;
    }

    public String getModuleURL() {
        return this.moduleURL;
    }
    
    public Object getController() {
        return this.controller;
    }
}
