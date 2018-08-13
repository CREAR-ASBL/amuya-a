
package com.amuyana.app.view.containers;

import com.amuyana.app.controllers.AppController;
import com.amuyana.app.data.Fcc;
import java.util.ArrayList;
import javafx.scene.Group;


public class ZContainer extends Group {

    private static AppController appController;
    
    //private Fcc fcc;
    
    // List of analogous fcc's (either a class or a conjunction)
    private ArrayList<Fcc> listAnalogousFccs;
    
    // List of MultiContainers of the analogous FCC's
    private ArrayList<MultiContainer> listMultiContainers;
    
    public ZContainer(){
        
    }

    /**
     * 
     * @param appController 
     */
    public static void setAppController(AppController appController) {
        ZContainer.appController = appController;
        
    }
    
    
    /**
     * Sets the main FCC. The ZContainer displays FccContainers one behind the
     * other, this method will position the introduced fcc in front,
     * @param fcc 
     */
    @Deprecated
    public void setFcc(Fcc fcc){
        // if the fcc is in the analougous list then ok, but I can't put any 
        // fcc, it must first be in the list of possibilities. Then count its
        // position and move the order of the children accordingly. But in any 
        // case the multicontainer should already be drawn?
        
        
    }
    
    
    
    /**
     * Set the analogous FCC's to be drawn behind the main FCC. This method
     * can be called at any time after the ZContainer has been created. It can
     * contain either a list of class or conjunction, but only at the time.
     */
    public void setListAnalogousFccs(ArrayList<Fcc> listAnalogousFccs){
        this.listAnalogousFccs=listAnalogousFccs;
    }
    
    
    
    
}
