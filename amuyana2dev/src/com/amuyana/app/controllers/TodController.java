
package com.amuyana.app.controllers;

import com.amuyana.app.data.CClass;
import com.amuyana.app.data.Fcc;
import com.amuyana.app.data.Inclusion;
import com.amuyana.app.styles.FormulaStyles;
import com.amuyana.app.view.containers.FccContainer;
import com.amuyana.app.view.containers.FormulaContainer;
import com.amuyana.app.view.containers.MultiContainer;
import com.amuyana.app.view.containers.ZContainer;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;


public class TodController implements Initializable {

    private AppController appController;
    
    private ObservableList<FormulaStyles> listStyles;
       
    @FXML private HBox todContent;
    
    // MENU BAR
    @FXML private TitledPane tdpeFcc;
    @FXML private TitledPane tdpeTod;
    @FXML private Accordion anMenu;
    
    // When nothing is selected, only menu of the TOD
    @FXML private ComboBox<FormulaStyles> cobxStyle;
    @FXML private ComboBox<Fcc> cobxFcc;
    @FXML private ComboBox<CClass> cobxCClass;
    @FXML private ComboBox<Inclusion> cobxInclusion;
    
    // When a FCC is selected
    @FXML private ToggleButton tebnExpandInclusions;
    @FXML private ToggleButton tebnExpandPositive;
    @FXML private ToggleButton tebnExpandNegative;
    @FXML private ToggleButton tebnExpandSymmetric;
    
    public static ArrayList<Fcc> listFccsInScene;
    
    //public static ArrayList<MultiContainer> listMultiContainers;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ZContainer.setAppController(appController);
        MultiContainer.setAppController(appController);
        FccContainer.setAppController(appController);
        FormulaContainer.setAppController(appController);
        
        listFccsInScene = new ArrayList<>();
        //listMultiContainers = new ArrayList<>();
        
        listStyles = FXCollections.observableArrayList();
        
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
        for(FormulaStyles f:FormulaStyles.values()){
            listStyles.add(f);
        }
        
        cobxStyle.setItems(listStyles);
        
        cobxStyle.getSelectionModel().selectFirst();
        cobxFcc.getSelectionModel().selectFirst();
        
    }
    
    public void manageEvents(){
        cobxFcc.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Fcc>() {
            @Override
            public void changed(ObservableValue<? extends Fcc> observable, Fcc oldValue, Fcc newValue) {
                if(newValue!=null){
                    // list of fcc's, setting the first one
                    listFccsInScene.clear();
                    listFccsInScene.add(newValue);
                    deploy();
                }
            }
        });
        
        cobxStyle.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<FormulaStyles>() {
            @Override
            public void changed(ObservableValue<? extends FormulaStyles> observable, FormulaStyles oldValue, FormulaStyles newValue) {
                if(newValue!=null){
                    FormulaContainer.setStyle(newValue);
                }
            }
        });
        
        c
    } 

    private void deploy() {
        // add zcontainer to todContent
        Fcc initialFcc = listFccsInScene.get(0);
        
        ZContainer firstZContainer = new ZContainer();
        
        //firstZContainer.setFcc(initialFcc);
        firstZContainer.setListAnalogousFccs(listFccsInScene);
        
        todContent.getChildren().add(firstZContainer);
        
    }
    
    @FXML
    public void debug(){
        if(anMenu.getPanes().contains(tdpeTod)){
            anMenu.getPanes().remove(tdpeTod);
        } else if(!anMenu.getPanes().contains(tdpeTod)){
            anMenu.getPanes().add(tdpeTod);
        } 
        
    }
    
    
    public void deployPosition0(MultiContainer multiContainer){
        // I add as many ZContainers as there are Fcc whose notions are 
        // generals to at least one dynamism of the fcc of multiContainer
        
    }
    
    public void deployPosition1(MultiContainer multiContainer){
        // I add one FccContainer only, the one that belong to the 
        // MultiContainer . This position should be deployed automatically...
        
    }
    
    public void deployPosition2(MultiContainer multiContainer){
        // I add as many ZContainers as there are notions that are particular 
        // in a inclusion with respect to the POSITIVE orientation of the Fcc 
        // of the MultiContainer 
        
    }
    public void deployPosition3(MultiContainer multiContainer){
        // I add as many ZContainers as there are notions that are particular 
        // in a inclusion with respect to the NEGATIVE orientation of the Fcc 
        // of the MultiContainer 
        
    }
    public void deployPosition4(MultiContainer multiContainer){
        // I add as many ZContainers as there are notions that are particular 
        // in a inclusion with respect to the SYMETTRIC orientation of the Fcc 
        // of the MultiContainer 
        
    }
    
//    public MultiContainer multiContainerOf(Fcc fcc){
//        for(MultiContainer m:listMultiContainers){
//            if(m.getFcc().equals(fcc)){
//                return m;
//            }
//        }
//        return null;
//    }
    
}
