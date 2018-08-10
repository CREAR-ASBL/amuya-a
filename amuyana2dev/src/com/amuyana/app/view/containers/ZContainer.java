
package com.amuyana.app.view.containers;

import com.amuyana.app.controllers.AppController;
import com.amuyana.app.data.Fcc;
import java.util.ArrayList;
import javafx.scene.Group;


public class ZContainer extends Group {

    private final AppController appController;
    
    
    
    public ZContainer(AppController appController, ArrayList<Fcc> listFcc){
        this.appController = appController;
        
    }
    
    
}
