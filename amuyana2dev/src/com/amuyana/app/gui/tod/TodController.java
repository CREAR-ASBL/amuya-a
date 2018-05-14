
package com.amuyana.app.gui.tod;

import com.amuyana.app.gui.AppController;
import com.amuyana.app.latex.Formula;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;


public class TodController implements Initializable {

    @FXML private AppController appController;
    
    @FXML private StackPane pane;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        //testHbox.getChildren().add(new Label("test successfull"));
    }    

    public void setAppController(AppController aThis) {
        this.appController=aThis;
        
    }

    @FXML
    private void defaultView(){
        
        //pane.setPrefSize(100, 100);
        //pane.setBackground(new Background(new BackgroundFill(Paint.valueOf("white"), CornerRadii.EMPTY, Insets.EMPTY)));
        //pane.getChildren().add(new Label("test"));
        //pane.getChildren().add(Formula.getFormula("blabl SD SDF FSD FaSD FSD FSDb laDSF SD DSF  Flblalb D alblkajb lkjb "));
    }
    
    private void log(String debug, String message) {
        
        appController.addLog(debug, message);
    }

    
}
