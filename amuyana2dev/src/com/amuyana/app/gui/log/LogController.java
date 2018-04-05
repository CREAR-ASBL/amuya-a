
package com.amuyana.app.gui.log;

import com.amuyana.app.gui.AppController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

public class LogController implements Initializable {

    private AppController appController;
   
    @FXML TableColumn tecn_date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setAppController(AppController aThis) {
        this.appController=aThis;
    }
    
    public void log(String date, String type, String user, String message){
        
    }
}
