/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.gui;

import javafx.scene.Node;

/**
 *
 * @author Ayar Portugal <ayar.portugal@amuyaña.com>
 */
public enum Module {
    LOGIC_SYSTEM("logicSystem/LogicSystem.fxml"),
    DUALITIES("dualities/Dualities.fxml"),
    INCLUSIONS("inclusion/Inclusion.fxml"),
    TOD("tod/Tod.fxml"),
    DIALECTIC("dialectic/Dialectic.fxml"),
    CLASSES("cclass/CClass.fxml"),
    STC("stc/Stc.fxml"),
    SYLLOGISM("syllogism/Syllogism.fxml"),
    STATS("stats/Stats.fxml"),
    SETTINGS("settings/Settings.fxml");
    
    private final String url;
    
    private Node node;
    
    private Module(String url) {
        this.url = url;

    }
    
    public void setNode(Node node){
        this.node=node;
    }
    
    public Node getNode() {
        return this.node;
    }
    
    public String getUrl() {
        return this.url;
    }

}
