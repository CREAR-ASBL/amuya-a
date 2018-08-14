
package com.amuyana.app.view.tod;

import com.amuyana.app.controllers.AppController;
import com.amuyana.app.controllers.TodController;
import com.amuyana.app.data.Fcc;
import com.amuyana.app.data.Inclusion;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class MultiContainer extends HBox {

    private static AppController appController;
    
    public Fcc fcc;
    
    public VBox positionLeft;
    public VBox positionCenter;
    
    public VBox positionRight;
    public VBox positionTop;
    public VBox positionMiddle;
    public VBox positionBottom;
    
    
    
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
            
    public MultiContainer(Fcc fcc) {
        
        this.fcc = fcc;
        
        //TodController.drawnFccs.add(this.mainFcc);
        
        positionLeft = new VBox();
        positionCenter = new VBox();
        positionTop = new VBox();
        positionMiddle = new VBox();
        positionBottom=  new VBox();
        positionRight = new VBox();
        
        //FccContainer fccContainer = new FccContainer(fcc, listDynamisms);
        
        positionRight.getChildren().addAll(positionTop,positionMiddle,positionBottom);
        
        super.getChildren().addAll(positionLeft,positionCenter,positionRight);
        
        //deploy0();
         
    }
    
    public static void setAppController(AppController appController) {
        MultiContainer.appController = appController;
    }

    public Fcc getFcc() {
        return fcc;
    }

    public void setFcc(Fcc fcc) {
        this.fcc = fcc;
    }

    
    
    public void deploy0(){
        // First find all Fcc that include the mainFcc,w
        for(Inclusion i:appController.getListInclusions()){
            if(i.getDynamism().equals(appController.dynamismOf(0, fcc))||
            i.getDynamism().equals(appController.dynamismOf(0, fcc))||
            i.getDynamism().equals(appController.dynamismOf(0, fcc))){
               // now grab the general (containing one or more conjunctions) that
               // has this inclusion (for now doesn't matter, we will not draw 
               // them specially like class)
               
               
               
               // then record the conjunction and the fcc
               // that will be connected later
               
            }
        }
        
        
        
        // Classify them in classes and put them in Zcontainer
        
        // one by one zContainer add it to the position0
        
        
    }
    
    
    public void deployPosition0(MultiContainer multiContainer){
        // I add as many ZContainers as there are Fcc whose notions are 
        // generals to at least one dynamism of the fcc of multiContainer
        
    }
    
    public void deployPosition1(MultiContainer multiContainer){
        // I add one FccContainer only, the one that belong to the 
        // MultiContainer . This position should be deployed automatically...
        
    }
    
    public void deployPosition2(MultiContainer multiContainer){
        // I add as many ZContainers as there are notions that are particular 
        // in a inclusion with respect to the POSITIVE orientation of the Fcc 
        // of the MultiContainer 
        
    }
    public void deployPosition3(MultiContainer multiContainer){
        // I add as many ZContainers as there are notions that are particular 
        // in a inclusion with respect to the NEGATIVE orientation of the Fcc 
        // of the MultiContainer 
        
    }
    public void deployPosition4(MultiContainer multiContainer){
        // I add as many ZContainers as there are notions that are particular 
        // in a inclusion with respect to the SYMETTRIC orientation of the Fcc 
        // of the MultiContainer 
        
    }
    
    
}
