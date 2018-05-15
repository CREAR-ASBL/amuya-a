
package com.amuyana.app.gui.tod;

import com.amuyana.app.formulas.Formula;
import com.amuyana.app.gui.AppController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class TodController implements Initializable {

    @FXML private AppController appController;
    @FXML private StackPane pane;
    @FXML private VBox vbox;
    @FXML private BorderPane borderpane;
    @FXML private ComboBox cobxFcc;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    public void d(){
        
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

    public VBox listConjunction(){
        VBox list = new VBox();
        
        //Formula.conjunction(0, element, antielement);
        
        return list;
    }
    
}
