
package com.amuyana.app.controllers;

import com.amuyana.app.data.Fcc;
import com.amuyana.app.view.containers.MultiContainer;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;


public class TodController implements Initializable {

    @FXML private AppController appController;
    
    @FXML private HBox todContent;
    @FXML private ComboBox cobxFcc;
    @FXML private TitledPane tdpeMenu;
    
    public static ArrayList<Fcc> drawnFccs;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        manageEvents();
    }
    
    public void setAppController(AppController aThis) {
        this.appController=aThis;
        
    }
    
    private void log(String debug, String message) {
        
        appController.addLog(debug, message);
    }

    public void fillData() {
        cobxFcc.setItems(appController.getListFcc());
        
    }
    
    public void manageEvents(){
        cobxFcc.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Fcc>() {
            @Override
            public void changed(ObservableValue<? extends Fcc> observable, Fcc oldValue, Fcc newValue) {
                if(newValue!=null){
                    // clear todContent
                    todContent.getChildren().clear();
                    draw(newValue);
                    
                }
            }
        });
    }

    public void draw(Fcc fcc){
        MultiContainer multiContainer = new MultiContainer(appController,fcc);
        todContent.getChildren().add(multiContainer);
    }
    
}
