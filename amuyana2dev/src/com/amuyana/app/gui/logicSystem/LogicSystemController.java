package com.amuyana.app.gui.logicSystem;

import com.amuyana.app.data.Conexion;
import com.amuyana.app.data.LogicSystem;
import com.amuyana.app.gui.AppController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LogicSystemController implements Initializable {

    // COMPONENTES GUI
    @FXML private AppController appController;
    
    @FXML private TextField ttfdSystemName;
    @FXML private Label llCreationDate;
    @FXML private TextArea ttaaDescription;

    @FXML private ComboBox<LogicSystem> cobxSystems;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    public void setAppController(AppController aThis) {
        this.appController=aThis;
    }
    
    public void fillData(ObservableList<LogicSystem> listLogicSystem){
        
        cobxSystems.setItems(listLogicSystem);
    }
    
}
