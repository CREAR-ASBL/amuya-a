/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.controllers;

import com.amuyana.app.data.Conexion;
import com.amuyana.app.data.Dynamism;

import com.amuyana.app.data.Element;
import com.amuyana.app.data.Fcc;
import com.amuyana.app.data.FccHasLogicSystem;

import com.amuyana.app.data.LogicSystem;
import com.amuyana.app.data.User;
import com.sun.javafx.property.adapter.PropertyDescriptor;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.web.HTMLEditor;

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
    @FXML private Button bnDuplicateFcc;
    @FXML private Button bnNewFcc;
    
    @FXML private TableView tevwFcc;
    @FXML private TableColumn<Fcc,String> tecnFccLabel;
    @FXML private TableColumn<Fcc,String> tecnFccDescription;
    
    @FXML private TextField ttfdFccId;
    @FXML private TextField ttfdFccLabel;
    @FXML private HTMLEditor hmerFccDescription;
    
    @FXML private ComboBox<LogicSystem> cobxLogicSystem;
    @FXML private Button bnAddLogicSystem;
    @FXML private Button bnRemoveLogicSystem;
    @FXML private ListView<LogicSystem> ltvwLogicSystem;
    
    @FXML private TextField ttfdElementSymbol;
    private TextField ttfdAElementSymbol;
    @FXML private HBox hxAntiElementSymbol;
    private Label llAElementSymbol;
    @FXML private CheckBox ckbxDefaultSymbol;
    
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

    private ObservableList<Element> listElement;
    private ObservableList<Dynamism> listDynamisms;
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
        this.listDynamisms=FXCollections.observableArrayList();
        
        ttfdAElementSymbol = new TextField();
        llAElementSymbol = new Label();
        llAElementSymbol.setPrefWidth(Control.USE_COMPUTED_SIZE);
        llAElementSymbol.setMinWidth(Control.USE_PREF_SIZE);
        
        llAElementSymbol.setStyle("-fx-border-style:solid inside;"
                + "-fx-border-width:1 0 0 0;");
        
        hxAntiElementSymbol.getChildren().add(llAElementSymbol);
        ckbxDefaultSymbol.setSelected(true);
        
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
    
    public ObservableList<Dynamism> getListDynamisms(){
        return this.listDynamisms;
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
        tevwFcc.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Fcc>() {
                @Override
                public void changed(ObservableValue<? extends Fcc> observable, 
                    Fcc oldValue, Fcc newValue) {
                    
                    Fcc selectedFcc = (Fcc)tevwFcc.getSelectionModel().getSelectedItem();
                    
                    if(newValue != null){
                        bnSaveFcc.setDisable(true);
                        bnUpdateFcc.setDisable(false);
                        bnDeleteFcc.setDisable(false);
                        bnDuplicateFcc.setDisable(false);
                        
                        // FCC section
                        ttfdFccId.setText(String.valueOf(newValue.getIdFcc()));
                        ttfdFccLabel.setText(newValue.getLabel());
                        hmerFccDescription.setHtmlText(newValue.getDescription());

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
                        
                        if(e.getSymbol().equals(ae.getSymbol())){
                            
                            hxAntiElementSymbol.getChildren().clear();
                            llAElementSymbol.setText(null);
                            hxAntiElementSymbol.getChildren().add(llAElementSymbol);
                            llAElementSymbol.setText(ae.getSymbol());
                            ckbxDefaultSymbol.setSelected(true);
                        } else if(!e.getSymbol().equals(ae.getSymbol())){
                            hxAntiElementSymbol.getChildren().clear();
                            ttfdAElementSymbol.setText(null);
                            hxAntiElementSymbol.getChildren().add(ttfdAElementSymbol);
                            ttfdAElementSymbol.setText(ae.getSymbol());
                            ckbxDefaultSymbol.setSelected(false);
                        }
                        
                        // DYNAMISMS section (previously known as CONJUNCTIONS)
                        
                        Dynamism c0 = appController.dynamismOf(0, selectedFcc);
                        Dynamism c1 = appController.dynamismOf(1, selectedFcc);
                        Dynamism c2 = appController.dynamismOf(2, selectedFcc);
                        
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
        
        // CHECKBOX OF ANTIELEMENT DEFAULT SYMBOL
        ckbxDefaultSymbol.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue==true){
                    hxAntiElementSymbol.getChildren().clear();
                    hxAntiElementSymbol.getChildren().add(llAElementSymbol);
                } else if (newValue==false){
                    hxAntiElementSymbol.getChildren().clear();
                    hxAntiElementSymbol.getChildren().add(ttfdAElementSymbol);
                    llAElementSymbol.setText(ttfdElementSymbol.getText());
                    System.out.println(ttfdElementSymbol.getText());
                }
            }
        });
        
        ttfdElementSymbol.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                llAElementSymbol.setText(newValue);
                
            }
        });
    }
    
    @FXML
    public void saveFcc(){
        Conexion conexion = appController.getConexion();
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        
        conexion.establecerConexion();
        
        //FCC
        Fcc fcc = new Fcc(0, ttfdFccLabel.getText(), hmerFccDescription.getHtmlText());
        
        int resultFcc = fcc.saveData(conexion.getConnection());
        fcc.setIdFcc(Fcc.currentAutoIncrement);
        
        if (resultFcc == 1){
            listFcc.add(fcc);
        }

        // Element
        Element e0 = new Element(0, ttfdElementSymbol.getText(), 0, fcc);
        Element e1 = null;
        if(ckbxDefaultSymbol.isSelected()==true) {
            e1 = new Element(0, llAElementSymbol.getText(), 1, fcc);
        } else if(ckbxDefaultSymbol.isSelected()==false) {
            e1 = new Element(0, ttfdAElementSymbol.getText(), 1, fcc);
        }
        
        
        int resultE0 = e0.saveData(conexion.getConnection());
        e0.setIdElement(Element.currentAutoIncrement);
        int resultE1 = e1.saveData(conexion.getConnection());
        e1.setIdElement(Element.currentAutoIncrement);
        
        if (resultE0 == 1 && resultE1 == 1){
            listElement.addAll(e0,e1);
        }
        
        // Dynamisms
        Dynamism c0 = new Dynamism(0, 0, ttfdPositiveFormulation.getText(), ttaaPositiveDescription.getText(), fcc);
        int resultC0 = c0.saveData(conexion.getConnection());
        c0.setIdDynamism(Dynamism.currentAutoIncrement);
        Dynamism c1 = new Dynamism(0, 1, ttfdNegativeFormulation.getText(), ttaaNegativeDescription.getText(), fcc);
        int resultC1 = c1.saveData(conexion.getConnection());
        c1.setIdDynamism(Dynamism.currentAutoIncrement);
        Dynamism c2 = new Dynamism(0, 2, ttfdSymmetricFormulation.getText(), ttaaSymmetricDescription.getText(), fcc);
        int resultC2 = c2.saveData(conexion.getConnection());
        c2.setIdDynamism(Dynamism.currentAutoIncrement);
        
        if(resultC0==1 && resultC1 == 1 && resultC2 == 1){
            listDynamisms.addAll(c0,c1,c2);
        }
        conexion.cerrarConexion();
        
        tevwFcc.getSelectionModel().selectLast();
        
        // UPDATE LIST IN INCLUSION
        appController.refreshDataInclusionModule();
        appController.refreshDataClassModule();
    }
    
    @FXML
    public void updateFcc(){
        Fcc selectedFcc = (Fcc)tevwFcc.getSelectionModel().getSelectedItem();
        
        String newFccLabel = ttfdFccLabel.getText();
        String newFccDescription = hmerFccDescription.getHtmlText();
        
        String newESymbol = ttfdElementSymbol.getText();
        String newAESymbol = null;
        // Anti element "default" checkbox has to be checked
        if(ckbxDefaultSymbol.isSelected()==true) {
            newAESymbol = llAElementSymbol.getText();
        } else if(ckbxDefaultSymbol.isSelected()==false) {
            newAESymbol = ttfdAElementSymbol.getText();
        }
        
        
        String newPropDynamism0 = ttfdPositiveFormulation.getText();
        String newPropDynamism1 = ttfdNegativeFormulation.getText();
        String newPropDynamism2 = ttfdSymmetricFormulation.getText();
        
        String newDescDynamism0 = ttaaPositiveDescription.getText();
        String newDescDynamism1 = ttaaNegativeDescription.getText();
        String newDescDynamism2 = ttaaSymmetricDescription.getText();
        
        int result;
        
        
        selectedFcc.setLabel(newFccLabel);
        selectedFcc.setDescription(newFccDescription);
        
        
        
        Conexion conexion = appController.getConexion();
        conexion.establecerConexion();
        
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
        
        
        
        // DYNAMISM
        Dynamism c0 = appController.dynamismOf(0, selectedFcc);
        Dynamism c1 = appController.dynamismOf(1, selectedFcc);;
        Dynamism c2 = appController.dynamismOf(2, selectedFcc);;
        int iC0=listDynamisms.indexOf(c0);
        int iC1=listDynamisms.indexOf(c1);
        int iC2=listDynamisms.indexOf(c2);
        
        c0.setPropFormulation(newPropDynamism0);
        c0.setDescription(newDescDynamism0);
        c1.setPropFormulation(newPropDynamism1);
        c1.setDescription(newDescDynamism1);
        c2.setPropFormulation(newPropDynamism2);
        c2.setDescription(newDescDynamism2);
        
        result = c0.updateData(conexion.getConnection());
        if (result == 1){
            listDynamisms.set(iC0, c0);
        }
        
        result = c1.updateData(conexion.getConnection());
        if (result == 1){
            listDynamisms.set(iC1, c1);
        }
        
        result = c2.updateData(conexion.getConnection());
        if (result == 1){
            listDynamisms.set(iC2, c2);
        }
        
        
        reselectFcc();
        
        conexion.cerrarConexion();
        
        // UPDATE LIST IN INCLUSION
        appController.refreshDataInclusionModule();
        appController.refreshDataClassModule();
    }
    
    @FXML
    public void deleteFcc(){
        Conexion conexion = appController.getConexion();
        conexion.establecerConexion();
        
        Fcc fcc = (Fcc)this.tevwFcc.getSelectionModel().getSelectedItem();
        
        ArrayList<Dynamism> tempListDynamisms = new ArrayList<>();
        ArrayList<Element> elements = new ArrayList<>();
        ArrayList<FccHasLogicSystem> fhlss = new ArrayList<>();
        
        // Dynamism
        for(Dynamism c:listDynamisms){
            if(c.getFcc().equals(fcc)){
                int response = c.deleteData(conexion.getConnection());
                if(response==1){
                    tempListDynamisms.add(c);
                }
            }
        }
        for(Dynamism c:tempListDynamisms){
            listDynamisms.remove(c);
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
        // UPDATE LIST IN INCLUSION
        appController.refreshDataInclusionModule();
        appController.refreshDataClassModule();
    }
    
    @FXML
    public void duplicateFcc(){
        Conexion conexion = appController.getConexion();
        //Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        
        conexion.establecerConexion();
        
        //current id of selected fcc
        Fcc selectedFcc = (Fcc)tevwFcc.getSelectionModel().getSelectedItem();
        String copy = "(Copy of FCC " + 
                String.valueOf(selectedFcc.getIdFcc()) + ") ";
        //FCC
        Fcc fcc = new Fcc(0, ttfdFccLabel.getText(), hmerFccDescription.getHtmlText());
        
        int resultFcc = fcc.saveData(conexion.getConnection());
        fcc.setIdFcc(Fcc.currentAutoIncrement);
        
        if (resultFcc == 1){
            listFcc.add(fcc);
        }

        // Element
        Element e0 = new Element(0, ttfdElementSymbol.getText(), 0, fcc);
        
        Element e1 = null;
        if(ckbxDefaultSymbol.isSelected()==true) {
            e1 = new Element(0, llAElementSymbol.getText(), 1, fcc);
        } else if(ckbxDefaultSymbol.isSelected()==false) {
            e1 = new Element(0, ttfdAElementSymbol.getText(), 1, fcc);
        }
        
        
        int resultE0 = e0.saveData(conexion.getConnection());
        e0.setIdElement(Element.currentAutoIncrement);
        int resultE1 = e1.saveData(conexion.getConnection());
        e1.setIdElement(Element.currentAutoIncrement);
        
        if (resultE0 == 1 && resultE1 == 1){
            listElement.addAll(e0,e1);
        }
        
        // Dynamism
        Dynamism c0 = new Dynamism(0, 0, ttfdPositiveFormulation.getText(), ttaaPositiveDescription.getText(), fcc);
        int resultC0 = c0.saveData(conexion.getConnection());
        c0.setIdDynamism(Dynamism.currentAutoIncrement);
        
        Dynamism c1 = new Dynamism(0, 1, ttfdNegativeFormulation.getText(), ttaaNegativeDescription.getText(), fcc);
        int resultC1 = c1.saveData(conexion.getConnection());
        c1.setIdDynamism(Dynamism.currentAutoIncrement);
        
        Dynamism c2 = new Dynamism(0, 2, ttfdSymmetricFormulation.getText(), ttaaSymmetricDescription.getText(), fcc);
        int resultC2 = c2.saveData(conexion.getConnection());
        c2.setIdDynamism(Dynamism.currentAutoIncrement);
        
        if(resultC0==1 && resultC1 == 1 && resultC2 == 1){
            listDynamisms.addAll(c0,c1,c2);
        }
        conexion.cerrarConexion();
        
        tevwFcc.getSelectionModel().selectLast();
        
        // UPDATE LIST IN INCLUSION
        appController.refreshDataInclusionModule();
        appController.refreshDataClassModule();
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
        hmerFccDescription.setHtmlText(null);
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
        bnDuplicateFcc.setDisable(true);

        
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
