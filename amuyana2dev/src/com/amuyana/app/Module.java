/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app;

import javafx.scene.Node;

/**
 *
 * @author Ayar Portugal <ayar.portugal@amuyaña.com>
 */
public enum Module {
    LOGIC_SYSTEM("/com/amuyana/app/view/LogicSystem.fxml"),
    DUALITIES("/com/amuyana/app/view/Dualities.fxml"),
    INCLUSIONS("/com/amuyana/app/view/Inclusion.fxml"),
    TOD("/com/amuyana/app/view/Tod.fxml"),
    DIALECTIC("/com/amuyana/app/view/Dialectic.fxml"),
    CLASSES("/com/amuyana/app/view/CClass.fxml"),
    STC("/com/amuyana/app/view/Stc.fxml"),
    SYLLOGISM("/com/amuyana/app/view/Syllogism.fxml"),
    STATS("/com/amuyana/app/view/Stats.fxml"),
    SETTINGS("/com/amuyana/app/view/Settings.fxml");
    
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
