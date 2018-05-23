
package com.amuyana.app.gui.inclusion;

import com.amuyana.app.data.Conexion;
import com.amuyana.app.data.Conjunction;
import com.amuyana.app.data.General;
import com.amuyana.app.data.Inclusion;
import com.amuyana.app.data.InclusionHasSyllogism;
import com.amuyana.app.gui.AppController;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;


public class InclusionController implements Initializable {
    private AppController appController;
    
    @FXML Button bnSave;
    @FXML Button bnUpdate;
    @FXML Button bnDelete;
    @FXML Button bnNew;
    
    @FXML ListView<Inclusion> ltvwInclusions;
    @FXML Label lbFormulaInclusion;
    @FXML ComboBox<Conjunction> cobxParticular;
    
    @FXML ListView<Conjunction> ltvwGeneralNotions;
    @FXML ListView<Conjunction> ltvwAllNotions;
    @FXML Button bnAdd;
    @FXML Button bnRemove;
    
    private ObservableList<Inclusion> listInclusion;
    private ObservableList<General> listGeneral;
    private ObservableList<Conjunction> listParticularNotions;
    private ObservableList<Conjunction> listAllNotions;
    private ObservableList<Conjunction> listGeneralNotions;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listInclusion = FXCollections.observableArrayList();
        listGeneral = FXCollections.observableArrayList();
        listParticularNotions = FXCollections.observableArrayList();
        listAllNotions = FXCollections.observableArrayList();
        listGeneralNotions = FXCollections.observableArrayList();
        
        manageEvents();
    }
    
    public ObservableList<Inclusion> getListInclusion(){
        return this.listInclusion;
    }
    
    public ObservableList<General> getListGeneral(){
        return this.listGeneral;
    }
    

    public void setAppController(AppController aThis) {
        this.appController=aThis;
    }

    public void fillData() {
        listParticularNotions = FXCollections.observableArrayList();
        
        ltvwInclusions.setItems(listInclusion);
        listParticularNotions.addAll(appController.getListConjunction());
        cobxParticular.setItems(listParticularNotions);
    }
    
    public void manageEvents(){
        ltvwInclusions.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Inclusion>() {
            @Override
            public void changed(ObservableValue<? extends Inclusion> observable, Inclusion oldValue, Inclusion newValue) {
                if(newValue!=null){
                    // BUTTONS
                    bnSave.setDisable(true);
                    bnDelete.setDisable(false);
                    bnUpdate.setDisable(false);
                    // PARTICULAR NOTION IN COMBOBOX
                    cobxParticular.getSelectionModel().select(newValue.getConjunction());
                    cobxParticular.setDisable(true);
                    
                    // FILTER BETWEEN NOTIONS AND GENERAL NOTIONS
                    ltvwGeneralNotions.setItems(null);
                    ltvwAllNotions.setItems(null);
                    
                    listParticularNotions = FXCollections.observableArrayList();
                    
                    listGeneralNotions = FXCollections.observableArrayList();
                    listAllNotions = FXCollections.observableArrayList();
                    
                    listAllNotions.addAll(appController.getListConjunction());
                    
                    for(General g:listGeneral){
                        if(g.getInclusion().getIdInclusion()==newValue.getIdInclusion()){
                            listAllNotions.remove(g.getConjunction());
                            listGeneralNotions.add(g.getConjunction());
                        }
                    }
                    
                    // Remove the notions of the fcc whose conjunction is included in general
                    Conjunction c0 = appController.conjunctionOf(0, newValue.getConjunction().getFcc());
                    Conjunction c1 = appController.conjunctionOf(1, newValue.getConjunction().getFcc());
                    Conjunction c2 = appController.conjunctionOf(2, newValue.getConjunction().getFcc());
                    
                    listAllNotions.remove(c0);
                    listAllNotions.remove(c1);
                    listAllNotions.remove(c2);
                    
                    ltvwGeneralNotions.setItems(listGeneralNotions);
                    ltvwAllNotions.setItems(listAllNotions);

                } else if (newValue==null){
                    //bnSave.setDisable(false);
                    bnDelete.setDisable(true);
                    bnUpdate.setDisable(true);
                    
                    cobxParticular.getSelectionModel().clearSelection();
                    cobxParticular.setDisable(false);
                    
                    ltvwAllNotions.setItems(null);
                    ltvwGeneralNotions.setItems(null);
                    
                    listGeneralNotions.clear();
                }
            }
        });
        
        ltvwAllNotions.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Conjunction>() {
            @Override
            public void changed(ObservableValue<? extends Conjunction> observable, Conjunction oldValue, Conjunction newValue) {
                if(newValue!=null){
                    bnAdd.setDisable(false);
                } else if (newValue==null){
                    bnAdd.setDisable(true);
                }
            }
        });
        
        ltvwGeneralNotions.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Conjunction>() {
            @Override
            public void changed(ObservableValue<? extends Conjunction> observable, Conjunction oldValue, Conjunction newValue) {
                if(newValue!=null){
                    bnRemove.setDisable(false);
                } else if (newValue==null){
                    bnRemove.setDisable(true);
                }
            }
        });
        
        cobxParticular.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Conjunction>() {
            @Override
            public void changed(ObservableValue<? extends Conjunction> observable, Conjunction oldValue, Conjunction newValue) {
                if(newValue!=null){
                    listAllNotions = FXCollections.observableArrayList();
                    listAllNotions.addAll(appController.getListConjunction());
                   
                    // Remove the notions of the fcc whose conjunction is included in general
                    Conjunction c0 = appController.conjunctionOf(0, newValue.getFcc());
                    Conjunction c1 = appController.conjunctionOf(1, newValue.getFcc());
                    Conjunction c2 = appController.conjunctionOf(2, newValue.getFcc());
                    
                    listAllNotions.remove(c0);
                    listAllNotions.remove(c1);
                    listAllNotions.remove(c2);
                    
                    ltvwGeneralNotions.setItems(listGeneralNotions);
                    ltvwAllNotions.setItems(listAllNotions);
                    
                    cobxParticular.setDisable(true);
                } else if (newValue==null){
                    listAllNotions.clear();
                }
            }
        });
    }
    
    public void reselectInclusion(){
        Inclusion i = (Inclusion)ltvwInclusions.getSelectionModel().getSelectedItem();
        ltvwInclusions.getSelectionModel().clearSelection();
        ltvwInclusions.getSelectionModel().select(i);
    }
    
    
    @FXML
    public void save(){
        
        // check that a Particular notion -a Conjunction- is selected
        if(cobxParticular.getSelectionModel().isEmpty()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Save Inclusion");
            alert.setHeaderText(null);
            alert.setContentText("Please select a particular notion.");
            alert.showAndWait();
            return;
        }
        
        // check that there's at least one General conjunction in the listGeneralNotions
        if(listGeneralNotions.isEmpty()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Save Inclusion");
            alert.setHeaderText(null);
            alert.setContentText("Please select at least one general notion.");
            alert.showAndWait();
            return;
        }
        
        // check that the disjunction doesn't exist yet
        // TODO: this is a bit more complex
        
        Conexion conexion = appController.getConexion();
        conexion.establecerConexion();
        
        Conjunction selectedConjunction = cobxParticular.getSelectionModel().getSelectedItem();
        
        //INCLUSION
        Inclusion newInclusion = new Inclusion(0, selectedConjunction);
        
        int result = newInclusion.saveData(conexion.getConnection());
        
        newInclusion.setIdInclusion(Inclusion.currentAutoIncrement);
        
        if (result == 1){
            listInclusion.add(newInclusion);
        }
        
        // GENERAL
        for(Conjunction c:listGeneralNotions){
            General newGeneral = new General(c, newInclusion);
            
            if(newGeneral.saveData(conexion.getConnection())==1){
                listGeneral.add(newGeneral);
            }
            
        }
        
        ltvwInclusions.getSelectionModel().selectLast();
        
        conexion.cerrarConexion();
    }
    
    @FXML
    public void update(){
        // check listGeneralNotions is not empty
        // TODO
        
        Inclusion selectedInclusion = ltvwInclusions.getSelectionModel().getSelectedItem();
        
        Conexion conexion = appController.getConexion();
        conexion.establecerConexion();
        General.dropData(conexion.getConnection(),selectedInclusion.getIdInclusion());
        //todo
        for(Conjunction c:listGeneralNotions){
            for(General g:listGeneral){
                if(g.getInclusion().equals(selectedInclusion) && g.getConjunction().equals(c)){
                    g.updateData(conexion.getConnection());
                }
            }
        }
        
        reselectInclusion();
        conexion.cerrarConexion();
    }
    
    @FXML
    public void delete(){
        Conexion conexion = appController.getConexion();
        conexion.establecerConexion();
        
        Inclusion i = ltvwInclusions.getSelectionModel().getSelectedItem();
        
        ArrayList<General> generals = new ArrayList<>();
        
        
        // find out if it has general
        for(General g:listGeneral){
            if(g.getInclusion().equals(i)){
                if(g.deleteData(conexion.getConnection())==1){
                    generals.add(g);
                }
            }
        }
        for(General g:generals){
            listGeneral.remove(g);
        }
        
        
        // Find out if it has syllogism
        // TODO
        
        
        // finally delete Inclusion
        if(i.deleteData(conexion.getConnection())==1){
            listInclusion.remove(i);
        }
        conexion.cerrarConexion();
    }
    
    @FXML
    public void newInclusion(){
        // Inclusion
        ltvwInclusions.getSelectionModel().clearSelection();
        
        // particular
        cobxParticular.getSelectionModel().clearSelection();
        cobxParticular.setDisable(false);
        
        // general
        ltvwGeneralNotions.setItems(null);
        listGeneralNotions.clear();
        
        // All notions
        ltvwAllNotions.setItems(null);
        listAllNotions.clear();
        
        bnSave.setDisable(false);
    }
    
    @FXML
    public void addGeneral(){
        Conjunction selectedConjunction = ltvwAllNotions.getSelectionModel().getSelectedItem();
        listGeneralNotions.add(selectedConjunction);
        listAllNotions.remove(selectedConjunction);
//        
//        //if the inclusion doesn't exist (check cobxParticularNotion)
//        if(ltvwInclusions.getSelectionModel().isEmpty()){
//            listGeneral.add(new General(selectedConjunction, cobxParticular.getSelectionModel().getSelectedItem()));
//        }
//        
//        // if the inclusion already exist (there's one selected)
//        listGeneral.add(
//                new General(selectedConjunction, ltvwInclusions.getSelectionModel().getSelectedItem())
//        );
//        
//        //update
    }
    
    @FXML
    public void removeGeneral(){
        Conjunction selectedConjunction = ltvwGeneralNotions.getSelectionModel().getSelectedItem();
        
        // if it would remain at least 1 conjunction then proceed
        if(listGeneralNotions.size()>1){
            listGeneralNotions.remove(selectedConjunction);
            listAllNotions.add(selectedConjunction);
            listGeneral.remove(generalOf(selectedConjunction,ltvwInclusions.getSelectionModel().getSelectedItem()));
        } else if(listGeneralNotions.size()==1){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Remove General notion");
            alert.setHeaderText(null);
            alert.setContentText("Can't remove the only General notion.");
            alert.showAndWait();
        }
        
    }
    
    public General generalOf(Conjunction conjunction, Inclusion inclusion){
        for(General g:listGeneral){
            if(g.getConjunction().equals(conjunction) && g.getInclusion().equals(inclusion)){
                return g;
            }
        }
        return null;
    }
}
