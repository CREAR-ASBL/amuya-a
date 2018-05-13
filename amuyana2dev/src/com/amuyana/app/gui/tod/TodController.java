/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.gui.tod;

import com.amuyana.app.gui.AppController;
import com.amuyana.app.latex.Formula;
import com.proudapes.jlatexmathfx.Control.LateXMathControl;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;



/**
 * FXML Controller class
 *
 * @author Ayar
 */
public class TodController implements Initializable {

    @FXML private AppController appController;
    @FXML private Button bnDefaultView;
    @FXML private HBox hbox;
    @FXML private Label label;
    @FXML private StackPane pane;
    @FXML private HBox testHbox;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        pane.getChildren().add(Formula.getFormula("bla"));
        
        //testHbox.getChildren().add(new Label("test successfull"));
    }    

    public void setAppController(AppController aThis) {
        this.appController=aThis;
    }

    @FXML
    private void defaultView(){
        
    }
    private void log(String debug, String message) {
        appController.addLog(debug, message);
    }
    
}
