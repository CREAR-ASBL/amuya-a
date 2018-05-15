
package com.amuyana.app.gui.tod;

import com.amuyana.app.data.Element;
import com.amuyana.app.data.Fcc;
import com.amuyana.app.formulas.Formula;
import com.amuyana.app.gui.AppController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class TodController implements Initializable {

    @FXML private AppController appController;
    @FXML private StackPane pane;
    @FXML private BorderPane borderpane;
    @FXML private ComboBox cobxFcc;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        manageEvents();
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
    
    public void manageEvents(){
        cobxFcc.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(newValue!=null){
                    draw((Fcc)newValue);
                }
            }
        });
    }

    public void draw(Fcc fcc){
        pane.getChildren().add(fccContainer(fcc));
    }
    
    private TitledPane fccContainer(Fcc fcc){
        Element e = appController.elementOf(0, fcc);
        Element ae = appController.elementOf(1, fcc);
        
        VBox content = new VBox(); 
        TitledPane fccContainer = new TitledPane(fcc.toString(), content);
        
        fccContainer.setCollapsible(false);
        fccContainer.setText(fcc.toString());
        fccContainer.setMaxWidth(200);
        
        content.getChildren().add(Formula.implication(0, e.getSymbol(), ae.getSymbol()));
        content.getChildren().add(Formula.implication(1, e.getSymbol(), ae.getSymbol()));
        content.getChildren().add(Formula.implication(2, e.getSymbol(), ae.getSymbol()));
        
        
        
        return fccContainer;
    }
    
}
