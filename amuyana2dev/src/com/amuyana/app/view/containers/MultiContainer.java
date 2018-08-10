
package com.amuyana.app.view.containers;

import com.amuyana.app.controllers.AppController;
import com.amuyana.app.controllers.TodController;
import com.amuyana.app.data.Fcc;
import com.amuyana.app.data.Inclusion;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class MultiContainer extends HBox {

    public Fcc mainFcc;
    public VBox position0;
    public VBox position1;
    public VBox position2;
    public VBox position3;
    public VBox position4;
    public VBox leftPositions;
    
    private final AppController appController;
    
    /** This is the central container.
     * It has 3 columns. 1st is for all the
     * previous dynamisms. 2dn is for
     * the central Fcc, 3d is for all other Fccs that are developments
     * of the orientations' dynamisms
     * However there are 5 positions, each holding not Fcc but ClassContainer
     * - 1st is the 1st column which is a VBox
     * - 2nd is the 2nd column which is also a VBox
     * - 3d is first position of VBox occupying the 3d column
     * - 4th is center 
     * - 5th is bottom
     * 
    */
            
    public MultiContainer(AppController appController, Fcc mainFcc) {
        this.appController=appController;
        this.mainFcc = mainFcc;
        TodController.drawnFccs.add(this.mainFcc);
        
        position0 = new VBox();
        position1 = new VBox();
        position2 = new VBox();
        position3 = new VBox();
        position4 = new VBox();
        leftPositions = new VBox();
        
        leftPositions.getChildren().addAll(position2,position3,position4);
        
        super.getChildren().addAll(position0,position1,leftPositions);
        
        deploy0();
         
    }
    
    public void deploy0(){
        // First find all Fcc that include the mainFcc,w
        for(Inclusion i:appController.getListInclusions()){
            if(i.getConjunction().equals(appController.conjunctionOf(0, mainFcc))||
            i.getConjunction().equals(appController.conjunctionOf(0, mainFcc))||
            i.getConjunction().equals(appController.conjunctionOf(0, mainFcc))){
               // now grab the general (containing one or more conjunctions) that
               // has this inclusion (for now doesn't matter, we will not draw 
               // them specially like class)
               
               
               
               // then record the conjunction and the fcc
               // that will be connected later
               
            }
        }
        
        
        // Classify them in classes and put them in Zcontainer
        
        // one by one zContainer add it to the position0
        position0.getChildren().add(null);
        
    }
    
    
}
