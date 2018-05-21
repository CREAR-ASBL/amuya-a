/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.gui.dualities;

import com.amuyana.app.data.Conexion;
import com.amuyana.app.data.Conjunction;
//import com.amuyana.app.data.Deduction;
import com.amuyana.app.data.Element;
import com.amuyana.app.data.Fcc;
import com.amuyana.app.data.FccHasLogicSystem;

import com.amuyana.app.data.LogicSystem;
import com.amuyana.app.data.User;
import com.amuyana.app.gui.AppController;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
    @FXML private Button bnSaveFcc;
    @FXML private Button bnUpdateFcc;
    @FXML private Button bnDeleteFcc;
    @FXML private Button bnNewFcc;
    
    @FXML private TableView tevwFcc;
    @FXML private TableColumn<Fcc,String> tecnFccLabel;
    @FXML private TableColumn<Fcc,String> tecnFccDescription;
    
    @FXML private TextField ttfdFccId;
    @FXML private TextField ttfdFccLabel;
    @FXML private TextArea ttaaFccDescription;
    
    @FXML private ComboBox<LogicSystem> cobxLogicSystem;
    @FXML private Button bnAddLogicSystem;
    @FXML private Button bnRemoveLogicSystem;
    @FXML private ListView<LogicSystem> ltvwLogicSystem;
    
//    @FXML private ComboBox cobxImplication;
//    @FXML private Button bnAddImplication;
//    @FXML private Button bnRemoveImplication;
//    @FXML private ListView<Implication> ltvwImplication;
//    @FXML private ListView<Deduction> ltvwDeduction;

    @FXML private TextField ttfdElementSymbol;
    @FXML private TextField ttfdAElementSymbol;
    
    @FXML private Label lblPositiveFormulation;
    @FXML private TextField ttfdPositiveFormulation;
    @FXML private TextArea ttaaPositiveDescription;
    @FXML private Label lblNegativeFormulation;
    @FXML private TextField ttfdNegativeFormulation;
    @FXML private TextArea ttaaNegativeDescription;
    @FXML private Label lblSymmetricFormulation;
    @FXML private TextField ttfdSymmetricFormulation;
    @FXML private TextArea ttaaSymmetricDescription;
    
    private ObservableList<Fcc> listFcc;
    private ObservableList<FccHasLogicSystem> listFccHasLogicSystem;
//    private ObservableList<Implication> listImplication;
//    private ObservableList<Deduction> listDeduction;
    
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
//        this.listImplication=FXCollections.observableArrayList();
//        this.listDeduction=FXCollections.observableArrayList();
        this.listElement=FXCollections.observableArrayList();
        this.listConjunction=FXCollections.observableArrayList();
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
    
    public ObservableList<Element> getListElement(){
        return this.listElement;
    }
    
    public ObservableList<Conjunction> getListConjunction(){
        return this.listConjunction;
    }
    
    public void fillData() {
        tevwFcc.setItems(listFcc);
        
        tecnFccLabel.setCellValueFactory(
            new PropertyValueFactory<Fcc,String>("label"));
        tecnFccDescription.setCellValueFactory(
            new PropertyValueFactory<Fcc,String>("description"));
        
        
    }
    
    public void manageEvents(){
        // TABLE VIEW WITH FCC
        tevwFcc.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Fcc>() {
                @Override
                public void changed(ObservableValue<? extends Fcc> observable, 
                    Fcc oldValue, Fcc newValue) {
                    
                    Fcc selectedFcc = (Fcc)tevwFcc.getSelectionModel().getSelectedItem();
                    
                    if(newValue != null){
                        bnSaveFcc.setDisable(true);
                        bnUpdateFcc.setDisable(false);
                        bnDeleteFcc.setDisable(false);
                        // FCC section
                        ttfdFccId.setText(String.valueOf(newValue.getIdFcc()));
                        ttfdFccLabel.setText(newValue.getLabel());
                        ttaaFccDescription.setText(newValue.getDescription());

                        // FCC HAS LOGIC SYSTEM section
                        ObservableList<LogicSystem> ls1 = FXCollections.observableArrayList();
                        ObservableList<LogicSystem> ls2 = FXCollections.observableArrayList();
                        
                        ls2.addAll(appController.getListLogicSystem());
                        
                        for(FccHasLogicSystem fhls : appController.getListFccHasLogicSystem()){
                            if(fhls.getFcc().equals(newValue)){
                                ls2.remove(fhls.getLogicSystem());
                                ls1.add(fhls.getLogicSystem());
                            }
                        }
                        
                        ltvwLogicSystem.setItems(ls1);
                        cobxLogicSystem.setItems(ls2);
                        cobxLogicSystem.setDisable(false);

                        // ELEMENTS section
                        Element e = appController.elementOf(0, selectedFcc);
                        Element ae= appController.elementOf(1, selectedFcc);
                        
                        ttfdElementSymbol.setText(e.getSymbol());
                        ttfdAElementSymbol.setText(ae.getSymbol());
                        
                        
                        // CONJUNCTIONS section
                        
                        Conjunction c0 = appController.conjunctionOf(0, selectedFcc);
                        Conjunction c1 = appController.conjunctionOf(1, selectedFcc);
                        Conjunction c2 = appController.conjunctionOf(2, selectedFcc);
                        
                        lblPositiveFormulation.setText(c0.toString());
                        ttfdPositiveFormulation.setText(c0.getPropFormulation());
                        ttaaPositiveDescription.setText(c0.getDescription());
                        
                        lblNegativeFormulation.setText(c0.toString());
                        ttfdNegativeFormulation.setText(c1.getPropFormulation());
                        ttaaNegativeDescription.setText(c1.getDescription());
                        
                        lblSymmetricFormulation.setText(c2.toString());
                        ttfdSymmetricFormulation.setText(c2.getPropFormulation());
                        ttaaSymmetricDescription.setText(c2.getDescription());
                        
                    } else if (newValue==null){
                        newFcc();
                    }
                    
                }
            }
        );
        
        //LIST VIEW WITH LOGIC SYSTEMS
        ltvwLogicSystem.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<LogicSystem>() {
            @Override
            public void changed(ObservableValue<? extends LogicSystem> observable, LogicSystem oldValue, LogicSystem newValue) {
                if(newValue!=null){
                    bnRemoveLogicSystem.setDisable(false);
                } else if (newValue==null){
                    bnRemoveLogicSystem.setDisable(true);
                }
                
            }
        });
        
        //COMBOBOX WITH LOGIC SYSTEMS
        cobxLogicSystem.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<LogicSystem>(){
            @Override
            public void changed(ObservableValue<? extends LogicSystem> observable, LogicSystem oldValue, LogicSystem newValue) {
                if(newValue!=null){
                    bnAddLogicSystem.setDisable(false);
                } else if(newValue==null){
                    bnAddLogicSystem.setDisable(true);
                }
            }
        });
    }
    
    @FXML
    public void saveFcc(){
        Conexion conexion = appController.getConexion();
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        
        conexion.establecerConexion();
        
        //FCC
        Fcc fcc = new Fcc(0, ttfdFccLabel.getText(), ttaaFccDescription.getText());
        
        int resultFcc = fcc.saveData(conexion.getConnection());
        fcc.setIdFcc(Fcc.currentAutoIncrement);
        
        if (resultFcc == 1){
            listFcc.add(fcc);
        }

        // Element
        Element e0 = new Element(0, ttfdElementSymbol.getText(), 0, fcc);
        Element e1 = new Element(0, ttfdAElementSymbol.getText(), 1, fcc);
        
        int resultE0 = e0.saveData(conexion.getConnection());
        e0.setIdElement(Element.currentAutoIncrement);
        int resultE1 = e1.saveData(conexion.getConnection());
        e1.setIdElement(Element.currentAutoIncrement);
        
        if (resultE0 == 1 && resultE1 == 1){
            listElement.addAll(e0,e1);
        }
        
        // Conjunction
        Conjunction c0 = new Conjunction(0, 0, ttfdPositiveFormulation.getText(), ttaaPositiveDescription.getText(), fcc);
        int resultC0 = c0.saveData(conexion.getConnection());
        c0.setIdConjunction(Conjunction.currentAutoIncrement);
        Conjunction c1 = new Conjunction(0, 1, ttfdNegativeFormulation.getText(), ttaaNegativeDescription.getText(), fcc);
        int resultC1 = c1.saveData(conexion.getConnection());
        c1.setIdConjunction(Conjunction.currentAutoIncrement);
        Conjunction c2 = new Conjunction(0, 2, ttfdSymmetricFormulation.getText(), ttaaSymmetricDescription.getText(), fcc);
        int resultC2 = c2.saveData(conexion.getConnection());
        c2.setIdConjunction(Conjunction.currentAutoIncrement);
        
        if(resultC0==1 && resultC1 == 1 && resultC2 == 1){
            listConjunction.addAll(c0,c1,c2);
        }
        conexion.cerrarConexion();
        
        tevwFcc.getSelectionModel().selectLast();
    }
    
    @FXML
    public void updateFcc(){
        Conexion conexion = appController.getConexion();
        conexion.establecerConexion();
        
        String newFccLabel = ttfdFccLabel.getText();
        String newFccDescription = ttaaFccDescription.getText();
        
        String newESymbol = ttfdElementSymbol.getText();
        String newAESymbol = ttfdAElementSymbol.getText();
        
        String newPConjunctionProp = ttfdPositiveFormulation.getText();
        String newNConjunctionProp = ttfdNegativeFormulation.getText();
        String newSConjunctionProp = ttfdSymmetricFormulation.getText();
        
        String newPConjunctionDesc = ttaaPositiveDescription.getText();
        String newNConjunctionDesc = ttaaNegativeDescription.getText();
        String newSConjunctionDesc = ttaaSymmetricDescription.getText();
        
        int result;
        
        Fcc selectedFcc = (Fcc)tevwFcc.getSelectionModel().getSelectedItem();
        
        selectedFcc.setLabel(newFccLabel);
        selectedFcc.setDescription(newFccDescription);
        
        result = selectedFcc.updateData(conexion.getConnection());
        
        if (result == 1){
            listFcc.set(listFcc.indexOf(selectedFcc), selectedFcc);
        }

        // ELEMENT
        Element e0 = appController.elementOf(0, selectedFcc);
        Element e1 = appController.elementOf(1, selectedFcc);
        
        int iE0=listElement.indexOf(e0);
        int iE1=listElement.indexOf(e1);
        
        e0.setSymbol(newESymbol);
        result = e0.updateData(conexion.getConnection());
        if (result == 1){
            listElement.set(iE0, e0);
        }
        
        e1.setSymbol(newAESymbol);
        result = e1.updateData(conexion.getConnection());
        if (result == 1){
            listElement.set(iE1, e1);
        }
        
        
        
        // CONJUNCTION
        Conjunction c0 = appController.conjunctionOf(0, selectedFcc);
        Conjunction c1 = appController.conjunctionOf(1, selectedFcc);;
        Conjunction c2 = appController.conjunctionOf(2, selectedFcc);;
        int iC0=listConjunction.indexOf(c0);
        int iC1=listConjunction.indexOf(c1);
        int iC2=listConjunction.indexOf(c2);
        
        c0.setPropFormulation(newPConjunctionProp);
        c0.setDescription(newPConjunctionDesc);
        c1.setPropFormulation(newNConjunctionProp);
        c1.setDescription(newNConjunctionDesc);
        c2.setPropFormulation(newSConjunctionProp);
        c2.setDescription(newSConjunctionDesc);
        
        result = c0.updateData(conexion.getConnection());
        if (result == 1){
            listConjunction.set(iC0, c0);
        }
        
        result = c1.updateData(conexion.getConnection());
        if (result == 1){
            listConjunction.set(iC1, c1);
        }
        
        result = c2.updateData(conexion.getConnection());
        if (result == 1){
            listConjunction.set(iC2, c2);
        }
        
        
        reselectFcc();
        
        conexion.cerrarConexion();
    }
    
    @FXML
    public void deleteFcc(){
        Conexion conexion = appController.getConexion();
        conexion.establecerConexion();
        
        Fcc fcc = (Fcc)this.tevwFcc.getSelectionModel().getSelectedItem();
        
        ArrayList<Conjunction> conjunctions = new ArrayList<>();
        ArrayList<Element> elements = new ArrayList<>();
        ArrayList<FccHasLogicSystem> fhlss = new ArrayList<>();
        
        // conjunction
        for(Conjunction c:listConjunction){
            if(c.getFcc().equals(fcc)){
                int response = c.deleteData(conexion.getConnection());
                if(response==1){
                    conjunctions.add(c);
                }
            }
        }
        for(Conjunction c:conjunctions){
            listConjunction.remove(c);
        }
        
        // element
        for(Element e:listElement){
            if(e.getFcc().equals(fcc)){
                if(e.deleteData(conexion.getConnection())==1){
                    elements.add(e);
                }
            }
        }
        for(Element e:elements){
            listElement.remove(e);
        }
        
        // logicSystem
        for(FccHasLogicSystem fhls : listFccHasLogicSystem){
            if(fhls.getFcc().equals(fcc)){
                if(fhls.deleteData(conexion.getConnection())==1){
                    fhlss.add(fhls);
                }
            }
        }
        for(FccHasLogicSystem f:fhlss){
            listFccHasLogicSystem.remove(f);
        }
        // fcc
        int resultado = fcc.deleteData(conexion.getConnection());
        if (resultado == 1){
                listFcc.remove(fcc);
        }
        
        conexion.cerrarConexion();
    
    }
    
    @FXML
    public void newFcc(){
        // take into account that this might be called when selection is already clear
        if(!tevwFcc.getSelectionModel().isEmpty()){
            tevwFcc.getSelectionModel().clearSelection();
        }
        
//        ltvwImplication.setItems(null);
        ltvwLogicSystem.setItems(null);
        cobxLogicSystem.getSelectionModel().clearSelection();
        cobxLogicSystem.setDisable(true);
//        cobxImplication.getSelectionModel().clearSelection();
//        cobxImplication.setDisable(true);
        lblPositiveFormulation.setText(null);
        lblNegativeFormulation.setText(null);
        lblSymmetricFormulation.setText(null);
        ttaaFccDescription.setText(null);
        ttaaNegativeDescription.setText(null);
        ttaaPositiveDescription.setText(null);
        ttaaSymmetricDescription.setText(null);
        ttfdAElementSymbol.setText(null);
        ttfdElementSymbol.setText(null);
        ttfdFccId.setText(null);
        ttfdFccLabel.setText(null);
        ttfdNegativeFormulation.setText(null);
        ttfdPositiveFormulation.setText(null);
        ttfdSymmetricFormulation.setText(null);
        
        bnSaveFcc.setDisable(false);
        bnUpdateFcc.setDisable(true);
        bnDeleteFcc.setDisable(true);

    }
    
    @FXML
    public void addLogicSystem(){
        Conexion conexion = appController.getConexion();
        conexion.establecerConexion();
        
        FccHasLogicSystem fhls = new FccHasLogicSystem(
                (Fcc)tevwFcc.getSelectionModel().getSelectedItem(),
                (LogicSystem)cobxLogicSystem.getSelectionModel().getSelectedItem()
        );
        
        int result = fhls.saveData(conexion.getConnection());
        
        if (result == 1){
            listFccHasLogicSystem.add(fhls);
            reselectFcc();
        }
        conexion.cerrarConexion();
    }
    
    @FXML
    public void removeLogicSystem(){
        Conexion conexion = appController.getConexion();
        conexion.establecerConexion();
        
        FccHasLogicSystem fhls = getFccHasLogicSystem();
        int resultado = fhls.deleteData(conexion.getConnection());
        conexion.cerrarConexion();
        
        if(resultado==1){
            listFccHasLogicSystem.remove(fhls);
            reselectFcc();
        }
        
    }

    public void log(String type, String message){
        appController.addLog(type, message);
    }

    private void reselectFcc() {
        Fcc r = (Fcc)tevwFcc.getSelectionModel().getSelectedItem();
        tevwFcc.getSelectionModel().clearSelection();
        tevwFcc.getSelectionModel().select(r);
    }

    private FccHasLogicSystem getFccHasLogicSystem() {
        for(FccHasLogicSystem fcls:listFccHasLogicSystem){
            if(fcls.getFcc()==tevwFcc.getSelectionModel().getSelectedItem()){
                if(fcls.getLogicSystem()==ltvwLogicSystem.getSelectionModel().getSelectedItem()){
                    return fcls;
                }
            }
        }
        
        return null;
    }

}
