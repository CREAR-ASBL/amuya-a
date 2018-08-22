/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.view.tod;

import com.amuyana.app.controllers.AppController;
import com.amuyana.app.data.Fcc;
import java.util.ArrayList;
import javafx.scene.layout.Pane;


public class TodContainer extends Pane {

    private static AppController appController;
    private Fcc initialFcc;

    // All Classes, all conjunctions!
    
    // Then all Fccs that are added
    
    public TodContainer(Fcc initialFcc) {
        this.initialFcc = initialFcc;
        ArrayList<Analogy> listAnalogy = appController.getListAnalogyForInitial(initialFcc);
        
        LevelContainer firstLevel = new LevelContainer(listAnalogy);
        super.getChildren().clear();
        super.getChildren().add(firstLevel);
        
    }
    
    public static void setAppController(AppController appController) {
        TodContainer.appController = appController;
        
    }
    
    
    
}
