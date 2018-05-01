package com.amuyana.app.gui;

import com.amuyana.app.data.Conexion;
import com.amuyana.app.data.Conjunction;
import com.amuyana.app.data.Deduction;
import com.amuyana.app.data.Dialectic;
import com.amuyana.app.data.Element;
import com.amuyana.app.data.Fcc;
import com.amuyana.app.data.Implication;
import com.amuyana.app.data.Log;
import com.amuyana.app.data.LogicSystem;
import com.amuyana.app.data.Register;
import com.amuyana.app.data.User;
import com.amuyana.app.gui.dialectic.DialecticController;
import com.amuyana.app.gui.log.LogController;
import com.amuyana.app.gui.dualities.DualitiesController;
import com.amuyana.app.gui.logicSystem.LogicSystemController;
import com.amuyana.app.gui.settings.SettingsController;
import com.amuyana.app.gui.stats.StatsController;
import com.amuyana.app.gui.stc.StcController;
import com.amuyana.app.gui.syllogism.SyllogismController;
import com.amuyana.app.gui.tod.TodController;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.collections.ObservableList;


public class AppController {
    
    private Conexion conexion;
        
    // CONTROLLERS
    @FXML private LogicSystemController logicSystemController;
    @FXML private DualitiesController dualitiesController;
    @FXML private TodController todController;
    @FXML private DialecticController dialecticController;
    @FXML private StcController stcController;
    @FXML private SyllogismController syllogismController;
    @FXML private StatsController statsController;
    @FXML private SettingsController settingsController;
    @FXML private LogController logController;
    
    // MAIN TABS
    @FXML Tab tab_logicSystem;
    @FXML Tab tab_dualities; 
    @FXML Tab tab_tod;
    @FXML Tab tab_dialectic;
    @FXML Tab tab_stc;
    @FXML Tab tab_syllogism;
    @FXML Tab tab_stats;
    @FXML Tab tab_settings;
    @FXML Tab tab_log;
    
    
    // COLECCIONES 
    private ObservableList<LogicSystem> listLogicSystem;
    private ObservableList<User> listUser;
    private ObservableList<Fcc> listFcc;
    private ObservableList<Element> listElement;
    private ObservableList<Deduction> listDeduction;
    private ObservableList<Implication> listImplication;
    private ObservableList<Conjunction> listConjunction;
    
    private ObservableList<Dialectic> listDialectic;
    
    private ObservableList<Register> listRegister;
    
    private ObservableList<Conjunction> listSpace;
    
    private ObservableList<Conjunction> listTime;
    
    private ObservableList<Conjunction> listQuantum;
    
    private ObservableList<Conjunction> listSyllogism;
    
    // Why is it instantiated this one?
    private ObservableList<Log> listLog = FXCollections.observableArrayList();
    
    public void initialize() throws IOException {
        
        loadModules();
        
        // auto connect to db and user
        settingsController.autoClicks();
        addLog("System", "AppController initialize() method succesfully executed.");
    }
    
    
    public ObservableList<LogicSystem> getListLogicSystem() {
        return listLogicSystem;
    }

    public ObservableList<User> getListUser() {
        return listUser;
    }

    public ObservableList<Fcc> getListFcc() {
        return listFcc;
    }

    public ObservableList<Element> getListElement() {
        return listElement;
    }

    public ObservableList<Deduction> getListDeduction() {
        return listDeduction;
    }

    public ObservableList<Implication> getListImplication() {
        return listImplication;
    }

    public ObservableList<Conjunction> getListConjunction() {
        return listConjunction;
    }

    public ObservableList<Dialectic> getListDialectic() {
        return listDialectic;
    }

    public ObservableList<Register> getListRegister() {
        return listRegister;
    }

    public ObservableList<Conjunction> getListSpace() {
        return listSpace;
    }

    public ObservableList<Conjunction> getListTime() {
        return listTime;
    }

    public ObservableList<Conjunction> getListQuantum() {
        return listQuantum;
    }

    public ObservableList<Conjunction> getListSyllogism() {
        return listSyllogism;
    }

    public ObservableList<Log> getListLog() {
        return listLog;
    }

    private void loadModules() throws IOException {
        for(Module m:Module.values()){
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource(m.getUrl()));
            Node node = loader.load();
            m.setNode(node);
            
            switch(m){
                case LOGIC_SYSTEM:{
                    this.logicSystemController = loader.getController();
                    this.logicSystemController.setAppController(this);
                    this.tab_logicSystem.setContent(m.getNode());
                    break;
                }
                case DUALITIES:{
                    this.dualitiesController = loader.getController();
                    this.dualitiesController.setAppController(this);
                    this.tab_dualities.setContent(m.getNode());
                    break;
                }
                case TOD:{
                    this.todController = loader.getController();
                    this.todController.setAppController(this);
                    this.tab_tod.setContent(m.getNode());
                    break;
                }
                case DIALECTIC:{
                    this.dialecticController = loader.getController();
                    this.dialecticController.setAppController(this);
                    this.tab_dialectic.setContent(m.getNode());
                    break;
                }
                case STC:{
                    this.stcController = loader.getController();
                    this.stcController.setAppController(this);
                    this.tab_stc.setContent(m.getNode());
                    break;
                }
                case SYLLOGISM:{
                    this.syllogismController = loader.getController();
                    this.syllogismController.setAppController(this);
                    this.tab_syllogism.setContent(m.getNode());
                    break;
                }
                case STATS:{
                    this.statsController = loader.getController();
                    this.statsController.setAppController(this);
                    this.tab_stats.setContent(m.getNode());
                    break;
                }
                case SETTINGS:{
                    this.settingsController = loader.getController();
                    this.settingsController.setAppController(this);
                    this.tab_settings.setContent(m.getNode());
                    break;
                }
                case LOG:{
                    this.logController = loader.getController();
                    this.logController.setAppController(this);
                    this.tab_log.setContent(m.getNode());
                    break;
                }
            }
        }
    }

    @FXML
    public void testButton1(){
        
    }
    
    @FXML
    public void testButton2(){
        
    }
    
    @FXML
    public void testButton3(){
        
    }

    private void loadSettings() {
        
    }

    public void connectToDb(String hostname, String dbUserName, String dbPassword) {
        // User has entered the db adress, we give default though
        
        // !! Are there unsaved changed in the current db? -> save first
        
        conexion = new Conexion();
        conexion.establecerConexion(hostname, dbUserName, dbPassword);
        
        // load and fill data because we call this method from connect button
        loadData(conexion);
        conexion.cerrarConexion();
    }

    private void loadData(Conexion conexion) {
        addLog("System", "Loading data into controls...");
        
        
        // other module data
        this.listImplication = FXCollections.observableArrayList();
        this.listDeduction = FXCollections.observableArrayList();
        this.listConjunction = FXCollections.observableArrayList();
        this.listDialectic = FXCollections.observableArrayList();
        this.listRegister = FXCollections.observableArrayList();
        this.listSpace = FXCollections.observableArrayList();
        this.listTime = FXCollections.observableArrayList();
        this.listQuantum = FXCollections.observableArrayList();
        this.listSyllogism = FXCollections.observableArrayList();
        
        
//        Implication.loadList(conexion.getConnection(), listImplication);
//        Deduction.loadList(conexion.getConnection(), listDeduction);
//        Conjunction.loadList(conexion.getConnection(), listConjunction);
//        Dialectic.loadList(conexion.getConnection(), listDialectic);
//        Register.loadList(conexion.getConnection(), listRegister);
//        Space.loadList(conexion.getConnection(), listSpace);
//        Time.loadList(conexion.getConnection(), listTime);
//        Quantum.loadList(conexion.getConnection(), listQuantum);
//        Syllogism.loadList(conexion.getConnection(), listSyllogism);
        
        
             
        for(Module m:Module.values()){
            switch(m){
                case LOGIC_SYSTEM:{
                    this.listLogicSystem = FXCollections.observableArrayList();
                    LogicSystem.loadList(conexion.getConnection(), this.listLogicSystem);
                    logicSystemController.fillData(this.listLogicSystem);
                    break;
                }
                case DUALITIES:{
                    this.listFcc = FXCollections.observableArrayList();
                    this.listElement = FXCollections.observableArrayList();
                    Fcc.loadList(conexion.getConnection(), listFcc, listLogicSystem);
                    Element.loadList(conexion.getConnection(), listElement);
                    dualitiesController.fillData(this.listFcc, this.listElement);
                    break;
                }
//                case TOD:{
//                    this.listLogicSystem = FXCollections.observableArrayList();
//                    logicSystemController.fillData(conexion, this.listLogicSystem);
//                    break;
//                }
//                case DIALECTIC:{
//                    this.listLogicSystem = FXCollections.observableArrayList();
//                    logicSystemController.fillData(conexion, this.listLogicSystem);
//                    break;
//                }
//                case STC:{
//                    this.listLogicSystem = FXCollections.observableArrayList();
//                    logicSystemController.fillData(conexion, this.listLogicSystem);
//                    break;
//                }
//                case SYLLOGISM:{
//                    this.listLogicSystem = FXCollections.observableArrayList();
//                    logicSystemController.fillData(conexion, this.listLogicSystem);
//                    break;
//                }
//                case STATS:{
//                    this.listLogicSystem = FXCollections.observableArrayList();
//                    logicSystemController.fillData(conexion, this.listLogicSystem);
//                    break;
//                }
                case SETTINGS:{
                    this.listLogicSystem = FXCollections.observableArrayList();
                    this.listUser = FXCollections.observableArrayList();
                    User.loadList(conexion.getConnection(), listUser);
                    break;
                }
            }
        }    
        addLog("System", "... all data succesfully loaded.");
    }    
    
    public void addLog(String type, String message){
        logController.addLog(type,message);
    }
}
