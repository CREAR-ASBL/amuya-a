/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.gui.dualities;

import com.amuyana.app.data.Element;
import com.amuyana.app.data.Fcc;

import com.amuyana.app.data.LogicSystem;
import com.amuyana.app.gui.AppController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    @FXML private TextField ttfdFccLabel;
    @FXML private TextArea ttfdFccDescription;
    @FXML private TextField ttfdElementSymbol;
    @FXML private TextField ttfdAElementSymbol;
    @FXML private ComboBox cobxConjunctions;
    @FXML private ListView ltvwConjunctions;
    @FXML private TableView tevwFcc;
    @FXML private TableColumn<Fcc,Integer> tecnFccId;
    @FXML private TableColumn<Fcc,String> tecnFccLabel;
    @FXML private TableColumn<Fcc,String> tecnFccDescription;
    @FXML private TableColumn<Fcc,Boolean> tecnFccInUse;
    @FXML private TableColumn<Fcc,LogicSystem> tecnLogicSystem;
    
    
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
    
    public void fillData(ObservableList<Fcc> listFcc, ObservableList<Element> listElement) {
        
        tevwFcc.setItems(listFcc);
        
        tecnFccId.setCellValueFactory(
            new PropertyValueFactory<Fcc,Integer>("idFcc"));
        tecnFccLabel.setCellValueFactory(
            new PropertyValueFactory<Fcc,String>("label"));
        tecnFccDescription.setCellValueFactory(
            new PropertyValueFactory<Fcc,String>("description"));
        tecnFccInUse.setCellValueFactory(
            new PropertyValueFactory<Fcc,Boolean>("inUse"));
        tecnLogicSystem.setCellValueFactory(
            new PropertyValueFactory<Fcc,LogicSystem>("logicSystem"));
    }
    
    public void manageEvents(){
        
        tevwFcc.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Fcc>() {
                @Override
                public void changed(ObservableValue<? extends Fcc> observable, 
                        Fcc oldValue, Fcc newValue) {
                        
                        ttfdFccLabel.setText(newValue.getLabel());
                        
                }
            }
        );
    }
}
