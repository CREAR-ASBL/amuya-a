
package com.amuyana.app.gui.cclass;

import com.amuyana.app.data.CClass;
import com.amuyana.app.data.CClassHasFcc;
import com.amuyana.app.data.Conexion;
import com.amuyana.app.data.Conjunction;
import com.amuyana.app.data.Fcc;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class CClassController implements Initializable {
    private AppController appController;
    
    @FXML Button bnSave;
    @FXML Button bnUpdate;
    @FXML Button bnDelete;
    @FXML Button bnNew;
    
    @FXML ListView<CClass> ltvwCClass;
    @FXML TextField ttfdLabel;
    
    @FXML ListView<Fcc> ltvwFcc;
    @FXML ListView<Fcc> ltvwCollection;
    @FXML Button bnAddToCollection;
    @FXML Button bnRemoveFromCollection;
    
    private ObservableList<CClass> listCClass;
    private ObservableList<CClassHasFcc> listCClassHasFcc;
    private ObservableList<Fcc> listCollection;
    private ObservableList<Fcc> listFcc;    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listCClass = FXCollections.observableArrayList();
        listCClassHasFcc = FXCollections.observableArrayList();
        listCollection = FXCollections.observableArrayList();
        listFcc = FXCollections.observableArrayList();
        
        manageEvents();
    }
    
    public ObservableList<CClass> getListCClass(){
        return this.listCClass;
    }
    
    public ObservableList<CClassHasFcc> getListCClassHasFcc(){
        return this.listCClassHasFcc;
    }
    
    public void setAppController(AppController aThis) {
        this.appController=aThis;
    }

    public void fillData() {
        ltvwCClass.setItems(listCClass);
    }
    
    public void manageEvents(){
        ltvwCClass.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CClass>() {
            @Override
            public void changed(ObservableValue<? extends CClass> observable, CClass oldValue, CClass newValue) {
                if(newValue!=null){
                    // BUTTONS
                    bnSave.setDisable(true);
                    bnDelete.setDisable(false);
                    bnUpdate.setDisable(false);
                    
                    // TextField
                    ttfdLabel.setText(newValue.getLabel());
                    
                    /* FCC and COLLECTION ListViews.
                    * Steps
                    * 1: Write all the Fccs of the collection
                    * 2: Write the remaining fccs in the listFcc. To do that:
                    * 3: find out what other candidates* exist and are not in the 
                    * listCollection already. Fcc candidates belong to 
                    * the same classes only if the fccs in the listCollection 
                    * belong all to those classes. As soon as the user picks 
                    * a fcc that does not belong to other classes, the fccs 
                    * in the listCollection are said to define a unique class. 
                    * So candidates belong at minimum to the same classes 
                    * existing in the listCollection but can belong to other 
                    * classes as well. 
                    * 
                    * *Candidates: these are fccs that share a same general 
                    * notions, that is they have the same @code Inclusion
                    **/
                    
                    
                    listCollection.clear();
                    listCollection.addAll(appController.fccOf(newValue));
                    ltvwCollection.setItems(listCollection);
                    
                    listFcc.clear();
                    ltvwFcc.setItems(getListCandidates(newValue));
                    

                } else if (newValue==null){
                    //bnSave.setDisable(false);
                    bnDelete.setDisable(true);
                    bnUpdate.setDisable(true);
                    
                }
            }
        });
        
        ltvwFcc.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Fcc>() {
            @Override
            public void changed(ObservableValue<? extends Fcc> observable, Fcc oldValue, Fcc newValue) {
                if(newValue!=null){
                    bnAddToCollection.setDisable(false);
                } else if (newValue==null){
                    bnAddToCollection.setDisable(true);
                }
            }
        });
        
        ltvwCollection.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Fcc>() {
            @Override
            public void changed(ObservableValue<? extends Fcc> observable, Fcc oldValue, Fcc newValue) {
                if(newValue!=null){
                    bnRemoveFromCollection.setDisable(false);
                } else if (newValue==null){
                    bnRemoveFromCollection.setDisable(true);
                }
            }
        });
        
    }
    
    /** STEPS.
     * 1. Find all common generals (which can be unique or a conjunction) 
     * of the Fcc's in the collection list, and print it in the UI (in 
     * common generals textField)
     * 2. From that list of common generals, one by one examine if there's 
     * another inclusion with the same generals but different particular which 
     * is not the same fcc already in the collection list, if there is add it to 
     * the listCandidates.
    */
    private ObservableList<Fcc> getListCandidates(CClass selectedCClass){
        ObservableList<Fcc> listCollection = ltvwCollection.getItems();
        
        // 1
        ArrayList<Conjunction> commonGenerals = new ArrayList<>();
        
        //ObservableList<Fcc> listFcc = FXCollections.observableArrayList();
        
        this.listFcc.addAll(appController.getListFcc());
        
        // for each inclusion 
        for(Fcc f1:listCollection){
            for(Conjunction c1:appController.generalsOf(f1)){
                for(Fcc f2:listCollection){
                    if(f1!=f2){
                        for(Conjunction c2:appController.generalsOf(f2)){
                            if(c1==c2){
                                if(!commonGenerals.contains(c1)){
                                    commonGenerals.add(c1);
                                }
                                
                            }
                        }
                    }
                    
                }
                
            }
        }
        
        for(Fcc f:appController.getListFcc()){
            for(Conjunction cg:commonGenerals){
                if(!appController.generalsOf(f).contains(cg)){
                    this.listFcc.remove(f);
                }
            }
        }
        ArrayList<Fcc> tempCandidates = new ArrayList<>();
        for(Fcc f1:this.listFcc){
            if(listCollection.contains(f1)){
                tempCandidates.add(f1);
            }
        }
        
        this.listFcc.removeAll(tempCandidates);
        
        return this.listFcc;
    }
    
    public void reselectCClass(){
        CClass c = (CClass)ltvwCClass.getSelectionModel().getSelectedItem();
        ltvwCClass.getSelectionModel().clearSelection();
        ltvwCClass.getSelectionModel().select(c);
    }
    
    
    @FXML
    public void save(){
        // check that a Label is given
        if(ttfdLabel.getText().isEmpty()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Save Class");
            alert.setHeaderText(null);
            alert.setContentText("Please provide a label for this class.");
            alert.showAndWait();
            return;
        }
        
        // check that there's at least one FCC in the Collection list
        if(listCollection.isEmpty()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Save Inclusion");
            alert.setHeaderText(null);
            alert.setContentText("Please select at least one general notion.");
            alert.showAndWait();
            return;
        }
        
        
        Conexion conexion = appController.getConexion();
        conexion.establecerConexion();
        
        //CCLASS
        CClass newCClass = new CClass(0, ttfdLabel.getText());
        
        int result = newCClass.saveData(conexion.getConnection());
        
        newCClass.setIdCClass(CClass.currentAutoIncrement);
        
        if (result == 1){
            listCClass.add(newCClass);
        }
        
        
        ltvwCClass.getSelectionModel().selectLast();
        
        conexion.cerrarConexion();
    }
    
    @FXML
    public void update(){
        CClass selectedCClass = ltvwCClass.getSelectionModel().getSelectedItem();
        
        Conexion conexion = appController.getConexion();
        conexion.establecerConexion();

        for(CClassHasFcc chf:listCClassHasFcc){
            
        }
        
        reselectCClass();
        conexion.cerrarConexion();
    }
    
    @FXML
    public void delete(){
        Conexion conexion = appController.getConexion();
        conexion.establecerConexion();
        
        CClass selectedCClass = ltvwCClass.getSelectionModel().getSelectedItem();
        
//        ArrayList<General> generals = new ArrayList<>();
//        
//        
//        // find out if it has general
//        for(General g:listGeneral){
//            if(g.getInclusion().equals(i)){
//                if(g.deleteData(conexion.getConnection())==1){
//                    generals.add(g);
//                }
//            }
//        }
//        for(General g:generals){
//            listGeneral.remove(g);
//        }
//        
//        
//        // Find out if it has syllogism
//        // TODO
//        
//        
//        // finally delete Inclusion
//        if(i.deleteData(conexion.getConnection())==1){
//            listInclusion.remove(i);
//        }
        conexion.cerrarConexion();
    }
    
    @FXML
    public void newCClass(){
        // CClass
        ltvwCClass.getSelectionModel().clearSelection();
        ttfdLabel.setText(null);
        
        // collection
        ltvwCollection.setItems(null);
        listCollection.clear();
        
        // All 
        //ltvwAllFcc.setItems();
        
        bnSave.setDisable(false);
    }
    
    @FXML
    public void addToCollection(){
        Fcc selectedFcc = ltvwFcc.getSelectionModel().getSelectedItem();
        
        listFcc.remove(selectedFcc);
        listCollection.add(selectedFcc);
    }
    
    @FXML
    public void removeFromCollection(){
        Fcc selectedFcc = ltvwCollection.getSelectionModel().getSelectedItem();
        
        if(listCollection.size()==1){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Cannot remove FCC from class");
            alert.setHeaderText(null);
            alert.setContentText("The class must have at least one FCC.");
            alert.showAndWait();
            return;
        }
        listFcc.add(selectedFcc);
        listCollection.remove(selectedFcc);
    }
    
    public ArrayList<CClass> cClassOf(Fcc fcc){
//        for(General g:listGeneral){
//            if(g.getConjunction().equals(conjunction) && g.getInclusion().equals(inclusion)){
//                return g;
//            }
//        }
        return null;
    }
}
