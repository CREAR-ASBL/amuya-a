package com.amuyana.app.gui.logicSystem;

import com.amuyana.app.data.LogicSystem;
import com.amuyana.app.gui.AppController;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class LogicSystemController implements Initializable {

    // COMPONENTES GUI
    @FXML private AppController appController;
    
    @FXML private TextField ttfdLabel;
    @FXML private Label llCreationDate;
    @FXML private TextArea ttaaDescription;

    @FXML private TableView tevwLogicSystem;
    @FXML TableColumn<LogicSystem, Number> tecnId;
    @FXML TableColumn<LogicSystem, String> tecnLabel;
    @FXML TableColumn<LogicSystem, String> tecnDescription;
    @FXML TableColumn<LogicSystem, Timestamp> tecnCreationDate;
    
    
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
        tevwLogicSystem.setItems(listLogicSystem);
        
        tecnId.setCellValueFactory(new PropertyValueFactory<LogicSystem,Number>("idLogicSystem"));
        tecnLabel.setCellValueFactory(new PropertyValueFactory<LogicSystem,String>("label"));
        tecnDescription.setCellValueFactory(new PropertyValueFactory<LogicSystem,String>("description"));
        tecnCreationDate.setCellValueFactory(new PropertyValueFactory<LogicSystem,Timestamp>("creationDate"));
                
    }
}