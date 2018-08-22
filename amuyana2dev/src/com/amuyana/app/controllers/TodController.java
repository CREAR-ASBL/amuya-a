
package com.amuyana.app.controllers;

import com.amuyana.app.data.CClass;
import com.amuyana.app.data.Dynamism;
import com.amuyana.app.data.Fcc;
import com.amuyana.app.data.General;
import com.amuyana.app.data.Inclusion;
import com.amuyana.app.styles.FormulaStyles;
import com.amuyana.app.view.tod.Analogy;
import com.amuyana.app.view.tod.FccContainer;
import com.amuyana.app.view.tod.FormulaContainer;
import com.amuyana.app.view.tod.LevelContainer;
import com.amuyana.app.view.tod.MultiContainer;
import com.amuyana.app.view.tod.TodContainer;
import com.amuyana.app.view.tod.AnalogyContainer;
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
    
    private TodContainer todContainer;
       
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
        
        
        listFccsInScene = new ArrayList<>();
        //listMultiContainers = new ArrayList<>();
        
        listStyles = FXCollections.observableArrayList();
        
        manageEvents();
        
    }
    
    public void setAppController(AppController aThis) {
        this.appController=aThis;
        
        TodContainer.setAppController(appController);
        LevelContainer.setAppController(appController);
        AnalogyContainer.setAppController(appController);
        MultiContainer.setAppController(appController);
        FccContainer.setAppController(appController);
        FormulaContainer.setAppController(appController);
        
    }
    
    public static ArrayList<Fcc> getListFccsInScene() {
        return listFccsInScene;
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
        
        //cobxStyle.getSelectionModel().selectFirst();
        //cobxFcc.getSelectionModel().selectFirst();
        
    }
    
    public void manageEvents(){
        cobxFcc.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Fcc>() {
            @Override
            public void changed(ObservableValue<? extends Fcc> observable, Fcc oldValue, Fcc newValue) {
                if(newValue!=null){
                    
                    // list of fcc's, setting the first one
                    listFccsInScene.clear();
                    listFccsInScene.add(newValue);
                    
                    deployInitial(newValue);
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
    }

    private void deployInitial(Fcc newValue) {
        
        this.todContainer = new TodContainer(newValue);
        todContent.getChildren().clear();
        todContent.getChildren().add(this.todContainer);
    }
    
    @FXML
    public void debug(){
        ArrayList<Analogy> listAnalogy = appController.getListAnalogyForInitial(cobxFcc.getSelectionModel().getSelectedItem());
        
        //System.out.println(listAnalogy);
        
    }
    
}
