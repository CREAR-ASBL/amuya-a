package com.amuyana.app.gui;

import com.amuyana.app.data.Conexion;
import com.amuyana.app.data.Conjunction;
import com.amuyana.app.data.Deduction;
import com.amuyana.app.data.Element;
import com.amuyana.app.data.Fcc;
import com.amuyana.app.data.FccHasLogicSystem;
import com.amuyana.app.data.Implication;
import com.amuyana.app.data.Log;
import com.amuyana.app.data.LogicSystem;
import com.amuyana.app.data.User;
import com.amuyana.app.gui.dialectic.DialecticController;
import com.amuyana.app.gui.dualities.DualitiesController;
import com.amuyana.app.gui.logicSystem.LogicSystemController;
import com.amuyana.app.gui.settings.SettingsController;
import com.amuyana.app.gui.stats.StatsController;
import com.amuyana.app.gui.stc.StcController;
import com.amuyana.app.gui.syllogism.SyllogismController;
import com.amuyana.app.gui.tod.TodController;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Paint;

public class AppController {
    
    private Conexion conexion;
    
    @FXML private SplitPane stpeContents;
    
    // CONTROLLERS
    @FXML private LogicSystemController logicSystemController;
    @FXML private DualitiesController dualitiesController;
    @FXML private TodController todController;
    @FXML private DialecticController dialecticController;
    @FXML private StcController stcController;
    @FXML private SyllogismController syllogismController;
    @FXML private StatsController statsController;
    @FXML private SettingsController settingsController;
    
    // MAIN TABS
    @FXML Tab tab_logicSystem;
    @FXML Tab tab_dualities; 
    @FXML Tab tab_tod;
    @FXML Tab tab_dialectic;
    @FXML Tab tab_stc;
    @FXML Tab tab_syllogism;
    @FXML Tab tab_stats;
    @FXML Tab tab_settings;
    
    // Why is it instantiated this one?
    private final ObservableList<Log> listLog = FXCollections.observableArrayList();
    
    // FOR LOG
    @FXML private MenuItem muimShowHideLog;
    
    private ScrollPane slpeLog;
    private TableView tevwLog;
    
    TableColumn<Log, Timestamp> tecnDate;
    TableColumn<Log, String> tecnType;
    TableColumn<Log, String> tecnMessage;

        
    
    public void initialize() throws IOException {
        initLog();
        
        this.conexion = new Conexion();
        
        loadModules();
        
        addLog("System", "Welcome to Amuyaña!");
        settingsController.autoClicks();
        
    }
    
    public ObservableList<LogicSystem> getListLogicSystem(){
        return logicSystemController.getListLogicSystem();
    }
    
    public ObservableList<Fcc> getListFcc(){
        return dualitiesController.getListFcc();
    }
    
    public ObservableList<FccHasLogicSystem> getListFccHasLogicSystem(){
        return dualitiesController.getListFccHasLogicSystem();
    }
    
    public ObservableList<Element> getListElement(){
        return dualitiesController.getListElement();
    }
    
    public ObservableList<Conjunction> getListConjunction(){
        return dualitiesController.getListConjunction();
    }
    
    public ObservableList<User> getListUser(){
        return settingsController.getListUser();
    }
    
    @FXML public void showHideLog(){
        System.out.println("muimShowHideLog.toString(): " + muimShowHideLog.toString());
        System.out.println("muimShowHideLog.getText(): " + muimShowHideLog.getText());
        if("Show Log panel".equals(muimShowHideLog.getText())) {
            stpeContents.getItems().add(slpeLog);
            muimShowHideLog.setText("Hide Log panel");
            
        } else if ("Hide Log panel".equals(muimShowHideLog.getText())){
            stpeContents.getItems().remove(stpeContents.getItems().size()-1);
            muimShowHideLog.setText("Show Log panel");
        }
    }
    
    public Conexion getConexion(){
        return this.conexion;
    }
    
    public void clearLists(){
        logicSystemController.getListLogicSystem().clear();
        
        
//        private ObservableList<User> listUser;
//        private ObservableList<Fcc> listFcc;
//        private ObservableList<Element> listElement;
//        private ObservableList<Deduction> listDeduction;
//        private ObservableList<Implication> listImplication;
//        private ObservableList<Conjunction> listConjunction;
//
//        private ObservableList<Dialectic> listDialectic;
//
//        private ObservableList<Register> listRegister;
//
//        private ObservableList<Conjunction> listSpace;
//
//        private ObservableList<Conjunction> listTime;
//
//        private ObservableList<Conjunction> listQuantum;
//
//        private ObservableList<Conjunction> listSyllogism;
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
            }
        }
    }

    public void loadData() {
        this.conexion.establecerConexion();
        
//        Dialectic.loadList(conexion.getConnection(), listDialectic);
//        Register.loadList(conexion.getConnection(), listRegister);
//        Space.loadList(conexion.getConnection(), listSpace);
//        Time.loadList(conexion.getConnection(), listTime);
//        Quantum.loadList(conexion.getConnection(), listQuantum);
//        Syllogism.loadList(conexion.getConnection(), listSyllogism);
        
        for(Module m:Module.values()){
            switch(m){
                case LOGIC_SYSTEM:{
                    LogicSystem.loadList(this.conexion.getConnection(), logicSystemController.getListLogicSystem());
                    logicSystemController.fillData();
                    break;
                }
                case DUALITIES:{
                    Fcc.loadList(this.conexion.getConnection(), dualitiesController.getListFcc());
                    
                    FccHasLogicSystem.loadList(this.conexion.getConnection(), 
                            dualitiesController.getListFccHasLogicSystem(), 
                            dualitiesController.getListFcc(), 
                            logicSystemController.getListLogicSystem());
                    
                    Implication.loadList(this.conexion.getConnection(),
                            dualitiesController.getListImplication(),
                            dualitiesController.getListFcc());
                    
                    Deduction.loadList(this.conexion.getConnection(),
                            dualitiesController.getListDeduction(),
                            dualitiesController.getListFcc(),
                            dualitiesController.getListImplication());
                    
                    Element.loadList(this.conexion.getConnection(), 
                            dualitiesController.getListElement(), 
                            dualitiesController.getListFcc());
                    
                    Conjunction.loadData(this.conexion.getConnection(), 
                            dualitiesController.getListConjunction(),
                            dualitiesController.getListFcc());
                    
                    dualitiesController.fillData();
                    
                    break;
                }
                case TOD:{
                    todController.fillData();
                    break;
                }
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
                    User.loadList(this.conexion.getConnection(), settingsController.getListUser());
                    break;
                }
            }
        }    
        
        conexion.cerrarConexion();
    }
    
    public void initLog(){
        
        tevwLog = new TableView(listLog);
        
        slpeLog = new ScrollPane(tevwLog);
        slpeLog.setFitToWidth(true);
        slpeLog.setFitToHeight(true);
        
        tecnDate = new TableColumn<>("Date");
        tecnType = new TableColumn<>("Type");
        tecnMessage = new TableColumn<>("Message");
        
        tecnDate.setCellValueFactory(new PropertyValueFactory<Log,Timestamp>("date"));
        tecnType.setCellValueFactory(new PropertyValueFactory<Log,String>("type"));
        tecnMessage.setCellValueFactory(new PropertyValueFactory<Log,String>("message"));
        
        tevwLog.getColumns().addAll(tecnDate,tecnType,tecnMessage);
        
        //listLog = FXCollections.observableArrayList();
        tevwLog.setItems(listLog);
        
//        tevwLog.getSelectionModel().selectedItemProperty().addListener(
//				new ChangeListener<Log>() {
//					@Override
//					public void changed(ObservableValue<? extends Log> arg0,
//							Log valorAnterior, Log valorSeleccionado) {
//                                            // TODO
//                                            System.out.println("selection was " + valorAnterior + " y ahora es: " + valorSeleccionado);
//                                    }
//                                }
//		);
        
        
    }
    
    public void addLog(String type, String message){
        listLog.add(new Log(Timestamp.valueOf(LocalDateTime.now()), type, message));
    }
    
    public Element elementOf(int polarity, Fcc fcc){
        for(Element e:getListElement()){
            if(e.getFcc().equals(fcc)){
                if(e.getPolarity()==polarity){
                    return e;
                }
            }
        }
        return null;
    }
    
    public Conjunction conjunctionOf(int orientation, Fcc fcc){
        for(Conjunction c:getListConjunction()){
            if(c.getFcc().equals(fcc)){
                if(c.getOrientation()==orientation){
                    return c;
                }
            }
        }
        return null;
    }
    
}
