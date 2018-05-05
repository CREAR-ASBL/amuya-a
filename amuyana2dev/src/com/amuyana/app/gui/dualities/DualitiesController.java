/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.gui.dualities;

import com.amuyana.app.data.Conjunction;
import com.amuyana.app.data.Element;
import com.amuyana.app.data.Fcc;
import com.amuyana.app.data.FccHasLogicSystem;
import com.amuyana.app.data.Implication;

import com.amuyana.app.data.LogicSystem;
import com.amuyana.app.data.User;
import com.amuyana.app.gui.AppController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Ayar
 */
public class DualitiesController implements Initializable {

    //private Conexion conexion;
    
    @FXML private AppController appController;
    
    // COMPONENTES GUI
    @FXML private TableView tevwFcc;
    @FXML private TableColumn<Fcc,String> tecnFccLabel;
    @FXML private TableColumn<Fcc,String> tecnFccDescription;
    
    @FXML private TextField ttfdFccId;
    @FXML private TextField ttfdFccLabel;
    @FXML private TextArea ttaaFccDescription;
    
    @FXML private ComboBox cobxLogicSystem;
    @FXML private Button bnAddLogicSystem;
    @FXML private Button bnRemoveLogicSystem;
    @FXML private ListView<LogicSystem> ltvwLogicSystem;
    
    @FXML private ComboBox cobxImplication;
    @FXML private Button bnAddImplication;
    @FXML private Button bnRemoveImplication;
    @FXML private ListView<Implication> ltvwImplication;

    @FXML private TextField ttfdElementSymbol;
    @FXML private TextField ttfdAElementSymbol;
    
    @FXML private TextField ttfdPositiveFormulation;
    @FXML private TextArea ttfdPositiveDescription;
    @FXML private TextField ttfdNegativeFormulation;
    @FXML private TextArea ttfdNevativeDescription;
    @FXML private TextField ttfdSymmetricFormulation;
    @FXML private TextArea ttfdSymmetricDescription;
    
    private ObservableList<Fcc> listFcc;
    //private ObservableList<LogicSystem> listLogicSystem;
    private ObservableList<FccHasLogicSystem> listFccHasLogicSystem;
    private ObservableList<Element> listElement;
    private ObservableList<Conjunction> listConjunction;
    private ObservableList<User> listUser;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.listFcc=FXCollections.observableArrayList();
        this.listFccHasLogicSystem=FXCollections.observableArrayList();
        //this.listLogicSystem=appController.getListLogicSystem();
        manageEvents();
    }

    public void setAppController(AppController aThis) {
        this.appController=aThis;
    }
    
    public ObservableList<Fcc> getListFcc() {
        return this.listFcc;
    }
    
    public ObservableList<FccHasLogicSystem> getListFccHasLogicSystem() {
        return this.listFccHasLogicSystem;
    }
    
    public void fillData() {
        
        tevwFcc.setItems(listFcc);
        
        tecnFccLabel.setCellValueFactory(
            new PropertyValueFactory<Fcc,String>("label"));
        tecnFccDescription.setCellValueFactory(
            new PropertyValueFactory<Fcc,String>("description"));
        
        
        
        
    }
    
    public void manageEvents(){
        
        tevwFcc.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Fcc>() {
                @Override
                public void changed(ObservableValue<? extends Fcc> observable, 
                    Fcc oldValue, Fcc newValue) {
                    // FCC 
                    ttfdFccId.setText(String.valueOf(newValue.getIdFcc()));
                    ttfdFccLabel.setText(newValue.getLabel());
                    ttaaFccDescription.setText(newValue.getDescription());
                        
                    // the selected fcc - newValue -, has 
                    ObservableList<LogicSystem> ls1 = FXCollections.observableArrayList();
                    ObservableList<LogicSystem> ls2 = FXCollections.observableArrayList();
                    
                    
                    
                    for(FccHasLogicSystem fhls: appController.getListFccHasLogicSystem()){
                        if(newValue.equals(fhls.getFcc())){
                            ls1.add(fhls.getLogicSystem());
                            //ls2.remove(fhls.getLogicSystem());
                        }
                    }
                    
                    ltvwLogicSystem.setItems(ls1);
                    cobxLogicSystem.setItems(ls2);
                    
                    
                    
                    
                    // Make a list with Logic Systems that have id of Fcc, 
                    // and that list show it in ListView, the rest put it in 
                    // ComboBox: EASY
                    
                    //ltvwLogicSystem.setItems(appController.getListLogicSystem());
                }
            }
        );
    }

    public void log(String type, String message){
        appController.addLog(type, message);
    }
    
    
    
}
