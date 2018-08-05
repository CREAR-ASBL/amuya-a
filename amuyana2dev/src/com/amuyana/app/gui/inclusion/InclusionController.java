
package com.amuyana.app.gui.inclusion;

import com.amuyana.app.data.Conexion;
import com.amuyana.app.data.Conjunction;
import com.amuyana.app.data.General;
import com.amuyana.app.data.Inclusion;
import com.amuyana.app.gui.AppController;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
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
    @FXML Button bnDelete;
    @FXML Button bnNew;
    
    @FXML ListView<Inclusion> ltvwInclusions;
    @FXML Label lbFormulaInclusion;
    @FXML ComboBox<Conjunction> cobxParticular;
    
    @FXML ListView<Conjunction> ltvwBroads;
    @FXML ListView<Conjunction> ltvwNotions;
    @FXML Button bnAdd;
    @FXML Button bnRemove;
    
    private ObservableList<Inclusion> listInclusions;
    private ObservableList<General> listGenerals;
    //private ArrayList<General> tempListGenerals;
    //private Inclusion tempInclusion;
    private ObservableList<Conjunction> listParticulars;
    private ObservableList<Conjunction> listNotions;
    private ObservableList<Conjunction> listBroads;
    
    private ObservableList<Conjunction> tempListBroads;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listInclusions = FXCollections.observableArrayList();
        listGenerals = FXCollections.observableArrayList();
        listParticulars = FXCollections.observableArrayList();
        
        // BROADS
        listBroads = FXCollections.observableArrayList();
        
        
        manageEvents();
    }
    
    public ObservableList<Inclusion> getListInclusions(){
        return this.listInclusions;
    }
    
    public ObservableList<General> getListGenerals(){
        return this.listGenerals;
    }
    

    public void setAppController(AppController aThis) {
        this.appController=aThis;
    }

    public void fillData() {
        ltvwInclusions.setItems(listInclusions);
        ltvwInclusions.getSelectionModel().selectFirst();
        
        //ltvwNotions.setItems(listNotions);
        ltvwBroads.setItems(listBroads);
        cobxParticular.setItems(listParticulars);
    }
    
    public void manageEvents(){
        ltvwInclusions.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Inclusion>() {
            @Override
            public void changed(ObservableValue<? extends Inclusion> observable, Inclusion oldValue, Inclusion newValue) {
                if(newValue!=null){
                    // BUTTONS
                    bnSave.setDisable(true);
                    bnDelete.setDisable(false);
                    bnAdd.setDisable(true);
                    bnRemove.setDisable(true);
                    // PARTICULAR COMBOBOX
                    cobxParticular.getSelectionModel().select(newValue.getConjunction());
                    cobxParticular.setDisable(true);
                    
                    // NOTIONS
                    listNotions = FXCollections.observableArrayList();
                    listNotions.addAll(appController.getListConjunctions());
                    ltvwNotions.setItems(listNotions);
                    
                        // Remove the notions of the fcc whose conjunction is included in general
                    Conjunction c0 = appController.conjunctionOf(0, newValue.getConjunction().getFcc());
                    Conjunction c1 = appController.conjunctionOf(1, newValue.getConjunction().getFcc());
                    Conjunction c2 = appController.conjunctionOf(2, newValue.getConjunction().getFcc());
                    
                    listNotions.remove(c0);
                    listNotions.remove(c1);
                    listNotions.remove(c2);
                    
                        
                    // BROAD : removing those notions that are contained in the 
                    //          general notion and putting them in listBroad
                    
                    listBroads = FXCollections.observableArrayList();
                    for(General g:listGenerals){
                        if(g.getInclusion().getIdInclusion()==newValue.getIdInclusion()){
                            listNotions.remove(g.getConjunction());
                            listBroads.add(g.getConjunction());
                        }
                    }
                    
                    ltvwBroads.setItems(listBroads);
                    
                } else if (newValue==null){
                    bnDelete.setDisable(true);
                    
                    cobxParticular.getSelectionModel().clearSelection();
                    cobxParticular.setDisable(false);
                    
                    ltvwNotions.setItems(null);
                    ltvwBroads.setItems(null);
                    
                    listNotions.clear();
                }
            }
        });
        
        ltvwNotions.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Conjunction>() {
            @Override
            public void changed(ObservableValue<? extends Conjunction> observable, Conjunction oldValue, Conjunction newValue) {
                if(ltvwInclusions.getSelectionModel().isEmpty()){
                    if(newValue!=null){
                        bnAdd.setDisable(false);
                    } else if (newValue==null){
                        bnAdd.setDisable(true);
                    }
                }
            }
        });
        
        ltvwBroads.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Conjunction>() {
            @Override
            public void changed(ObservableValue<? extends Conjunction> observable, Conjunction oldValue, Conjunction newValue) {
                if(ltvwInclusions.getSelectionModel().isEmpty()){
                    if(newValue!=null){
                        bnRemove.setDisable(false);
                    } else if (newValue==null){
                        bnRemove.setDisable(true);
                    }
                }
                    
            }
        });
        
        cobxParticular.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Conjunction>() {
            @Override
            public void changed(ObservableValue<? extends Conjunction> observable, Conjunction oldValue, Conjunction newValue) {
                if(newValue!=null){
                    
                    listNotions = FXCollections.observableArrayList();
                    listNotions.addAll(appController.getListConjunctions());
                    ltvwNotions.setItems(listNotions);
                    
                    // Remove the notions of the fcc whose conjunction is included in general
                    Conjunction c0 = appController.conjunctionOf(0, newValue.getFcc());
                    Conjunction c1 = appController.conjunctionOf(1, newValue.getFcc());
                    Conjunction c2 = appController.conjunctionOf(2, newValue.getFcc());
                    
                    listNotions.remove(c0);
                    listNotions.remove(c1);
                    listNotions.remove(c2);
                    
                    //ltvwBroads.setItems(listBroads);
                    
                    cobxParticular.setDisable(true);
                } else if (newValue==null){
                    listNotions.clear();
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
        if(listBroads.isEmpty()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Save Inclusion");
            alert.setHeaderText(null);
            alert.setContentText("Please select at least one general notion.");
            alert.showAndWait();
            return;
        }
        
        // check that the inclusion doesn't exist yet
        if(!isInclusionUnique()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Save Inclusion");
            alert.setHeaderText(null);
            alert.setContentText("This Inclusion already exists.");
            alert.showAndWait();
            return;
        }
        
        Conexion conexion = appController.getConexion();
        conexion.establecerConexion();
        
        //INCLUSION
        Inclusion newInclusion = new Inclusion(0, cobxParticular.getSelectionModel().getSelectedItem());
        
        int result = newInclusion.saveData(conexion.getConnection());
        
        newInclusion.setIdInclusion(Inclusion.currentAutoIncrement);
        
        if (result == 1){
            listInclusions.add(newInclusion);
        }
        
        // GENERAL
        for(Conjunction c:tempListBroads){
            General newGeneral = new General(c, newInclusion);
            if(newGeneral.saveData(conexion.getConnection())==1){
                listGenerals.add(newGeneral);
            }
        }
        //cobxParticular.setItems(listAllNotions);
        ltvwInclusions.getSelectionModel().selectLast();
        
        conexion.cerrarConexion();
    }

    @FXML
    public void delete(){
        Conexion conexion = appController.getConexion();
        conexion.establecerConexion();
        
        Inclusion i = ltvwInclusions.getSelectionModel().getSelectedItem();
        
        ArrayList<General> generals = new ArrayList<>();
        
        
        // find out if it has general
        for(General g:listGenerals){
            if(g.getInclusion().equals(i)){
                if(g.deleteData(conexion.getConnection())==1){
                    generals.add(g);
                }
            }
        }
        for(General g:generals){
            listGenerals.remove(g);
        }
        
        
        // Find out if it has syllogism
        // TODO
        
        
        // finally delete Inclusion
        if(i.deleteData(conexion.getConnection())==1){
            listInclusions.remove(i);
        }
        conexion.cerrarConexion();
    }
    
    @FXML
    public void newInclusion(){
        // temporary list of broads
        tempListBroads = FXCollections.observableArrayList();
        
        // Inclusion
        //tempInclusion = new Inclusion();
        ltvwInclusions.getSelectionModel().clearSelection();
        
        // particular
        listParticulars.clear();
        listParticulars.addAll(appController.getListConjunctions());
        cobxParticular.setDisable(false);
        cobxParticular.getSelectionModel().clearSelection();
        // Broad

        listBroads.clear();
        
        // Notions
        listNotions.clear();
        
        bnSave.setDisable(false);
        
        bnAdd.setDisable(true);
        bnRemove.setDisable(true);
    }
    
    @FXML
    public void addGeneral(){
        Conjunction selectedConjunction = ltvwNotions.getSelectionModel().getSelectedItem();
        
        // if there's not an existing Inclusion, we add the selected notion to
        // a temporary list of conjunctions that will be in the Broad list 
        if(ltvwInclusions.getSelectionModel().isEmpty()){
            listBroads.add(selectedConjunction);
            ltvwBroads.setItems(listBroads);
            listNotions.remove(selectedConjunction);
            tempListBroads.add(selectedConjunction);
        }
        // if the inclusion already exist (there's one selected)
        else if (!ltvwInclusions.getSelectionModel().isEmpty()){
            Conexion conexion = appController.getConexion();
            conexion.establecerConexion();
            
            General newGeneral = new General(selectedConjunction,
                    ltvwInclusions.getSelectionModel().getSelectedItem());
            
            if(newGeneral.saveData(conexion.getConnection())==1){
                listBroads.add(selectedConjunction);
                listNotions.remove(selectedConjunction);
                listGenerals.add(newGeneral);
            }
            conexion.cerrarConexion();
        }
    }
    
    @FXML
    public void removeGeneral(){
        Conjunction selectedConjunction = ltvwBroads.getSelectionModel().getSelectedItem();
        
        // if it would remain at least 1 conjunction then proceed
        if(listBroads.size()>1){
            // If the inclusion is not created yet
            if(ltvwInclusions.getSelectionModel().isEmpty()){
                tempListBroads.remove(selectedConjunction);
                listBroads.remove(selectedConjunction);
                listNotions.add(selectedConjunction);
            } 
            // If the inclusion exists already
            else if(!ltvwInclusions.getSelectionModel().isEmpty()){
                General general = generalOf(selectedConjunction,
                        ltvwInclusions.getSelectionModel().getSelectedItem());
                
                Conexion conexion = appController.getConexion();
                conexion.establecerConexion();
                
                if(general.deleteData(conexion.getConnection())==1){
                    listGenerals.remove(general);
                    listBroads.remove(selectedConjunction);
                    listNotions.add(selectedConjunction);
                }
                conexion.cerrarConexion();
            }
        } else if(listBroads.size()==1){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Remove General notion");
            alert.setHeaderText(null);
            alert.setContentText("Can't remove the only General notion.");
            alert.showAndWait();
        }
    }
    
    public General generalOf(Conjunction conjunction, Inclusion inclusion){
        for(General g:listGenerals){
            if(g.getConjunction().equals(conjunction) && g.getInclusion().equals(inclusion)){
                return g;
            }
        }
        return null;
    }

    // This method is called only at the moment of save() only
    private boolean isInclusionUnique() {
        Conjunction particular = cobxParticular.getSelectionModel().getSelectedItem();
        ObservableList<Conjunction> tempConjunctions;

        for(Inclusion i:listInclusions){
            tempConjunctions = FXCollections.observableArrayList();
            if(i.getConjunction().equals(particular)){
                for(General g:listGenerals){
                    if(g.getInclusion().equals(i)){
                        tempConjunctions.add(g.getConjunction());
                    }
                }
            }
            SortedList<Conjunction> list1 = tempListBroads.sorted();
            SortedList<Conjunction> list2 = tempConjunctions.sorted();

            if(list1.equals(list2)){
                return false;
            }
        }
        return true;
    }
}
