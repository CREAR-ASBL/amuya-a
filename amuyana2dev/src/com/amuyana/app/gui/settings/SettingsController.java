package com.amuyana.app.gui.settings;

import com.amuyana.app.data.User;
import com.amuyana.app.gui.AppController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SettingsController implements Initializable {

    @FXML private AppController appController;

    @FXML private Button btnConnect;
    @FXML private Button btnLogInOut;
    
    @FXML private TextField ttfdHostname;
    @FXML private TextField ttfdDbUsername;
    @FXML private TextField ttfdDbPassword;
    
    @FXML private TextField ttfdUserName;
    @FXML private TextField ttfdUserPassword;
    @FXML private Label lblDateJoined;
    
    private User currentUser;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setAppController(AppController aThis) {
        this.appController=aThis;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    
    @FXML
    private void connectToDb(){
        appController.connectToDb(ttfdHostname.getText(), ttfdDbUsername.getText(), ttfdDbPassword.getText());
    }
    
    @FXML
    private void logInOutUser(ActionEvent e){
        // If it is not logged in, try to login
        if(btnLogInOut.getText().equals("Login")){
            for(User user:this.appController.getListUser()){
                if(this.ttfdUserName.getText().equals(user.getUsername())){
                    if(this.ttfdUserPassword.getText().equals(user.getPassword())){
                        setCurrentUser(user);
                        
                        this.ttfdUserName.setDisable(true);
                        this.ttfdUserPassword.setDisable(true);
                        this.lblDateJoined.setText(user.getDate().toString());
                        this.btnLogInOut.setText("Logout");
                        
                    }
                }
            }
        // If it is logged in, log out
        } else if(btnLogInOut.getText().equals("Logout")){
            setCurrentUser(null);
            this.ttfdUserName.setDisable(false);
            this.ttfdUserPassword.setDisable(false);
            ttfdUserName.setText("");
            ttfdUserPassword.setText("");
            lblDateJoined.setText("");
            btnLogInOut.setText("Login");
        }
    }

    public void autoClicks() {
        btnConnect.fire();
        btnLogInOut.fire();
    }
}
