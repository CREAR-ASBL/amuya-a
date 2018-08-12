
package com.amuyana.app.view.containers;

import com.amuyana.app.controllers.AppController;
import com.amuyana.app.data.Fcc;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;


public class ZContainer extends Group {

    private static AppController appController;
    private int position;
    
    public ZContainer(){
        //this.setTranslateX(10);
        
    }

    
    
    public static void setAppController(AppController appController) {
        ZContainer.appController = appController;
        
    }
    
    public void setPosition(int position){
        this.position=position;
    }
    
    
}
