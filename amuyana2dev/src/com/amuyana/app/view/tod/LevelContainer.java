/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.view.tod;

import com.amuyana.app.controllers.AppController;
import java.util.ArrayList;
import javafx.scene.layout.VBox;

/**
 *
 * @author ayar
 */
public class LevelContainer extends VBox {

    private ArrayList<Analogy> listAnalogy;
    private static AppController appController;

    public LevelContainer(ArrayList<Analogy> listAnalogy) {
        this.listAnalogy = listAnalogy;
        
        for(Analogy a:listAnalogy){
            AnalogyContainer analogyContainer = new AnalogyContainer(a);
            super.getChildren().add(analogyContainer);
        }
        
        super.setSpacing(5);
        
    }
    
    public static void setAppController(AppController appController) {
        LevelContainer.appController = appController;
    }
    
}
