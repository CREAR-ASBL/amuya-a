
package com.amuyana.app.gui.syllogism;

import com.amuyana.app.data.Inclusion;
import com.amuyana.app.data.InclusionHasSyllogism;
import com.amuyana.app.data.Syllogism;
import com.amuyana.app.gui.AppController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SyllogismController implements Initializable {

    private AppController appController;
    
    // SYLLOGISM
    @FXML Button bnSave;
    @FXML Button bnUpdate;
    @FXML Button bnDelete;
    @FXML Button bnNew;
    
    @FXML TextField ttfdLabel;
    
    @FXML ListView ltvwSyllogism;
    @FXML ListView ltvwAllInclusions;
    @FXML ListView ltvwAssInclusions;
    
    @FXML Button bnAdd;
    @FXML Button bnRemove;
    
    ObservableList<Syllogism> listSyllogisms;
    ObservableList<InclusionHasSyllogism> listIHS;
    ObservableList<Inclusion> listAllInclusions;
    ObservableList<Inclusion> listAssInclusions;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listSyllogisms = FXCollections.observableArrayList();
        listAllInclusions = FXCollections.observableArrayList();
        listAssInclusions = FXCollections.observableArrayList();
        
    }    
    
    public ObservableList<Syllogism> getListSyllogism(){
        return this.listSyllogisms;
    }
    
    public ObservableList<InclusionHasSyllogism> getListIHS(){
        return this.listIHS;
    }

    public void setAppController(AppController aThis) {
        this.appController=aThis;
    }

    public void fillData() {
        ltvwSyllogism.setItems(listSyllogisms);
    }
    
}
