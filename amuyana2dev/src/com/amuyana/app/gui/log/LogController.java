
package com.amuyana.app.gui.log;

import com.amuyana.app.data.Log;
import com.amuyana.app.data.User;
import com.amuyana.app.gui.AppController;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LogController implements Initializable {

    private AppController appController;
   
    @FXML TableView tevwLog;
    
    @FXML TableColumn<Log, Timestamp> tecnDate;
    @FXML TableColumn<Log, String> tecnType;
    @FXML TableColumn<Log, String> tecnMessage;

    ObservableList<Log> logList;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupTableView();
    }    

    public void setAppController(AppController aThis) {
        this.appController=aThis;
    }

    public void setupTableView(){
        tecnDate.setCellValueFactory(new PropertyValueFactory<Log,Timestamp>("date"));
        tecnType.setCellValueFactory(new PropertyValueFactory<Log,String>("type"));
        tecnMessage.setCellValueFactory(new PropertyValueFactory<Log,String>("message"));
        
        logList = FXCollections.observableArrayList();
        
        tevwLog.setItems(logList);
        
        
        tevwLog.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Log>() {
					@Override
					public void changed(ObservableValue<? extends Log> arg0,
							Log valorAnterior, Log valorSeleccionado) {
                                            // TODO
                                            System.out.println("selection was " + valorAnterior + " y ahora es: " + valorSeleccionado);
                                    }
                                }
		);
        
        
    }
    
    public void addLog(String type, String message){
        logList.add(new Log(Timestamp.valueOf(LocalDateTime.now()), type, message));
    }
   
}
