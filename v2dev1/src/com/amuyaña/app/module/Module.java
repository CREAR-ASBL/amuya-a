/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyaña.app.module;

import com.amuyaña.app.module.logger.LoggerController;
import javafx.scene.control.ScrollPane;

/**
 *
 * @author Ayar Portugal <ayar.portugal@amuyaña.com>
 */
public enum Module {
    
    DEFAULT_MODULE("module/Blank.fxml", "module/Blank.fxml", "module/Blank.fxml"),
    LOGGER("module/logger/Left.fxml", "module/logger/Logger.fxml", "module/logger/Right.fxml");
    private String urlLeft;
    private String urlCenter;
    private String urlRight;
    private ScrollPane leftPane;
    private ScrollPane centerPane;
    private ScrollPane rightPane;
    
    private Module(String urlLeft, String urlCenter, String urlRight) {
        this.urlLeft = urlLeft;
        this.urlCenter = urlCenter;
        this.urlRight = urlRight;
        
    }
    public void setPanes(ScrollPane sp1, ScrollPane sp2, ScrollPane sp3){
        this.leftPane=sp1;
        this.centerPane=sp2;
        this.rightPane=sp3;
    }
    
    public String getUrlLeft() {
        return urlLeft;
    }

    public String getUrlCenter() {
        return urlCenter;
    }

    public String getUrlRight() {
        return urlRight;
    }

    public ScrollPane getLeftPane() {
        return leftPane;
    }

    public ScrollPane getCenterPane() {
        return centerPane;
    }

    public ScrollPane getRightPane() {
        return rightPane;
    }

}
